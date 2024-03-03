package junseok.snr.redisplayground.groupclass.application.service;

import junseok.snr.redisplayground.groupclass.domain.GroupClassSetting;
import junseok.snr.redisplayground.groupclass.infrastructure.GroupClassSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupClassSettingServiceImpl implements GroupClassSettingService {
    private final GroupClassSettingRepository groupClassSettingRepository;
    private final Environment environment;
    @CachePut(value = "lessonSetting", key = "#result.seqGroupClassSetting + ':' + T(java.util.Arrays).stream(@environment.getActiveProfiles()).collect(T(java.util.stream.Collectors).joining(','))")
    @Override
    public GroupClassSetting create(GroupClassSetting groupClassSetting) {
        return groupClassSettingRepository.save(groupClassSetting);
    }

    @CachePut(value = "lessonSetting", key = "#result.seqGroupClassSetting + ':' + @environment.getActiveProfiles()")
    @Override
    public GroupClassSetting update(GroupClassSetting groupClassSetting) {
        return groupClassSettingRepository.save(groupClassSetting);
    }

    @CacheEvict(value = "lessonSetting", key = "#id + ':' + @environment.getActiveProfiles()")
    @Override
    public void delete(int id) {
        groupClassSettingRepository.deleteById(id);
    }

    @Cacheable(value = "lessonSetting", key = "#id + ':' + @environment.getActiveProfiles()")
    @Override
    public Optional<GroupClassSetting> findById(int id) {
        return groupClassSettingRepository.findById(id);
    }
}
