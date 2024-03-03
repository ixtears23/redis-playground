package junseok.snr.redisplayground.lesson.application;

import junseok.snr.redisplayground.lesson.domain.LessonSetting;
import junseok.snr.redisplayground.lesson.infrastructure.LessonSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonSettingServiceImpl implements LessonSettingService {
    private final LessonSettingRepository lessonSettingRepository;
    private final Environment environment;
    @CachePut(value = "lessonSettingCache", key = "'lessoneSetting:' + #result.seqLessonSetting + ':' + T(java.util.Arrays).toString(environment.getActiveProfiles())")
    @Override
    public LessonSetting create(LessonSetting lessonSetting) {
        return lessonSettingRepository.save(lessonSetting);
    }

    @CachePut(value = "lessonSettingCache", key = "'lessoneSetting:' + #result.seqLessonSetting + ':' + T(java.util.Arrays).toString(environment.getActiveProfiles())")
    @Override
    public LessonSetting update(LessonSetting lessonSetting) {
        return lessonSettingRepository.save(lessonSetting);
    }

    @CacheEvict(value = "lessonSettingCache", key = "'lessoneSetting:' + #id + ':' + T(java.util.Arrays).toString(environment.getActiveProfiles())")
    @Override
    public void delete(int id) {
        lessonSettingRepository.deleteById(id);
    }

    @Cacheable(value = "lessonSettingCache", key = "'lessoneSetting:' + #id + ':' + T(java.util.Arrays).toString(environment.getActiveProfiles())")
    @Override
    public Optional<LessonSetting> findById(int id) {
        return lessonSettingRepository.findById(id);
    }
}
