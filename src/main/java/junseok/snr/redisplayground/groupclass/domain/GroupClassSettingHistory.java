package junseok.snr.redisplayground.groupclass.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class GroupClassSettingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seqLessonSettingHistory;
    private Integer seqGroupClassSetting;
    @Enumerated(EnumType.STRING)
    private AutoPublishSettingType autoPublishSettingType;
    private Integer autoPublishSettingCycle;
    private Integer autoPublishSettingPeriod;
    private Byte autoPublishSettingDay;
    private LocalTime autoPublishSettingTime;
    private Byte autoCancelSettingCount;
    private Integer autoCancelSettingTime;
    private LocalDateTime regDt;
    private Integer regId;
}
