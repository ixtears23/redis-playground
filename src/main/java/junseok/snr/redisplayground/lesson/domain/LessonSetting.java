package junseok.snr.redisplayground.lesson.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LessonSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seqLessonSetting;
    private Integer seqPartnerLesson;
    @Enumerated(EnumType.STRING)
    private AutoOpenSettingType autoOpenSettingType;
    private Integer autoOpenSettingCycle;
    private Integer autoOpenSettingPeriod;
    private Byte autoOpenSettingDay;
    private LocalTime autoOpenSettingTime;
    private Byte autoCancelSettingCount;
    private Integer autoCancelSettingTime;
}
