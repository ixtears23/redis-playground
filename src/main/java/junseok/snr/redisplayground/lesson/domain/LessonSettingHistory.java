package junseok.snr.redisplayground.lesson.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class LessonSettingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seqLessonSettingHistory;
    private Integer seqLessonSetting;
    private Integer seqPartnerLesson;
    @Enumerated(EnumType.ORDINAL)
    private AutoOpenSettingType autoOpenSettingType;
    private Integer autoOpenSettingCycle;
    private Integer autoOpenSettingPeriod;
    private Byte autoOpenSettingDay;
    private LocalTime autoOpenSettingTime;
    private Byte autoCancelSettingCount;
    private Integer autoCancelSettingTime;
    private LocalDateTime regDt;
    private Integer regId;
}
