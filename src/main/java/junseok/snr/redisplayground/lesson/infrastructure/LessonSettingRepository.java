package junseok.snr.redisplayground.lesson.infrastructure;

import junseok.snr.redisplayground.lesson.domain.LessonSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonSettingRepository extends JpaRepository<LessonSetting, Integer> {
}
