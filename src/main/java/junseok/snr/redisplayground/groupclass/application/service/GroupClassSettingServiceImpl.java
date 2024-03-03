package junseok.snr.redisplayground.groupclass.application.service;

import junseok.snr.redisplayground.groupclass.application.dto.GroupClassSettingDto;
import junseok.snr.redisplayground.groupclass.application.dto.GroupClassSettingDtoMapper;
import junseok.snr.redisplayground.groupclass.domain.GroupClassSetting;
import junseok.snr.redisplayground.groupclass.domain.GroupClassSettingMapper;
import junseok.snr.redisplayground.groupclass.infrastructure.GroupClassSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupClassSettingServiceImpl implements GroupClassSettingService {
    private final GroupClassSettingRepository groupClassSettingRepository;
    private final GroupClassSettingMapper groupClassSettingMapper;
    private final GroupClassSettingDtoMapper groupClassSettingDtoMapper;
    @Cacheable(value = "group-class-setting", key = "#id + ':' + @environment.getActiveProfiles()")
    @Override
    public Optional<GroupClassSettingDto> findById(int id) {
        Optional<GroupClassSetting> groupClassSetting = groupClassSettingRepository.findById(id);
        return Optional.of(
                groupClassSettingDtoMapper.groupClassSettingDtoTo(
                        groupClassSetting.orElse(GroupClassSetting.builder().build())
                )
        );
    }

    @CachePut(value = "group-class-setting", key = "#result.seqGroupClassSetting + ':' + T(java.util.Arrays).stream(@environment.getActiveProfiles()).collect(T(java.util.stream.Collectors).joining(','))")
    @Override
    public GroupClassSettingDto create(GroupClassSettingDto groupClassSettingDto) {
        GroupClassSetting groupClassSetting = groupClassSettingRepository.save(groupClassSettingMapper.groupClassSettingTo(groupClassSettingDto));
        return groupClassSettingDtoMapper.groupClassSettingDtoTo(groupClassSetting);
    }

    @CachePut(value = "group-class-setting", key = "#result.seqGroupClassSetting + ':' + @environment.getActiveProfiles()")
    @Override
    public GroupClassSettingDto update(GroupClassSettingDto groupClassSettingDto) {
        GroupClassSetting groupClassSetting = groupClassSettingRepository.save(groupClassSettingMapper.groupClassSettingTo(groupClassSettingDto));
        return groupClassSettingDtoMapper.groupClassSettingDtoTo(groupClassSetting);
    }

    @CacheEvict(value = "group-class-setting", key = "#id + ':' + @environment.getActiveProfiles()")
    @Override
    public void delete(int id) {
        groupClassSettingRepository.deleteById(id);
    }
}
