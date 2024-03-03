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
    @CachePut(value = "lessonSetting", key = "#result.seqLessonSetting + ':' + T(java.util.Arrays).stream(@environment.getActiveProfiles()).collect(T(java.util.stream.Collectors).joining(','))")
    @Override
    public LessonSetting create(LessonSetting lessonSetting) {
        return lessonSettingRepository.save(lessonSetting);
    }

    @CachePut(value = "lessonSetting", key = "#result.seqLessonSetting + ':' + @environment.getActiveProfiles()")
    @Override
    public LessonSetting update(LessonSetting lessonSetting) {
        return lessonSettingRepository.save(lessonSetting);
    }

    @CacheEvict(value = "lessonSetting", key = "#id + ':' + @environment.getActiveProfiles()")
    @Override
    public void delete(int id) {
        lessonSettingRepository.deleteById(id);
    }

    @Cacheable(value = "lessonSetting", key = "#id + ':' + @environment.getActiveProfiles()")
    @Override
    public Optional<LessonSetting> findById(int id) {
        return lessonSettingRepository.findById(id);
    }
}
