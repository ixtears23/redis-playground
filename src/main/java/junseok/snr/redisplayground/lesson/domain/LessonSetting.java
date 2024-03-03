package junseok.snr.redisplayground.lesson.domain;


import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table
public class LessonSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
