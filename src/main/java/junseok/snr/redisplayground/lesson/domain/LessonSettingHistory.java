package junseok.snr.redisplayground.lesson.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class LessonSettingHistory {
    @Id
    private Integer seqLessonSettingHistory;
    private Integer seqLessonSetting;
    private Integer seqPartnerLesson;
    private Character autoOpenSettingType;
    private Integer autoOpenSettingCycle;
    private Integer autoOpenSettingPeriod;
    private Byte autoOpenSettingDay;
    private LocalTime autoOpenSettingTime;
    private Byte autoCancelSettingCount;
    private Integer autoCancelSettingTime;
    private LocalDateTime regDt;
    private Integer regId;
}
