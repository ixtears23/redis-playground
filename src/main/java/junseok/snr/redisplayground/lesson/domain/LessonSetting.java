package junseok.snr.redisplayground.lesson.domain;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class LessonSetting implements Serializable {
    private static final long serialVersionUID = 1L;

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
