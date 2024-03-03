package junseok.snr.redisplayground.lesson.application;

import junseok.snr.redisplayground.lesson.domain.LessonSetting;
import junseok.snr.redisplayground.lesson.infrastructure.LessonSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonSettingServiceImpl implements LessonSettingService {
    private final LessonSettingRepository lessonSettingRepository;
    @Override
    public LessonSetting create(LessonSetting lessonSetting) {
        return lessonSettingRepository.save(lessonSetting);
    }

    @Override
    public LessonSetting update(LessonSetting lessonSetting) {
        return lessonSettingRepository.save(lessonSetting);
    }

    @Override
    public Optional<LessonSetting> findById(int id) {
        return lessonSettingRepository.findById(id);
    }
}
