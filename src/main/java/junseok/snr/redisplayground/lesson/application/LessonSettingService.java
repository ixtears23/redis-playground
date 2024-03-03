package junseok.snr.redisplayground.lesson.application;

import junseok.snr.redisplayground.lesson.domain.LessonSetting;

import java.util.Optional;

public interface LessonSettingService {
    LessonSetting create(LessonSetting lessonSetting);
    LessonSetting update(LessonSetting lessonSetting);
    Optional<LessonSetting> findById(int id);
}
