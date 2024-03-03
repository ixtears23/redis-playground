package junseok.snr.redisplayground.groupclass.domain;


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
public class GroupClassSetting implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seqGroupClassSetting;
    @Enumerated(EnumType.STRING)
    private AutoPublishSettingType autoPublishSettingType;
    private Integer autoPublishSettingCycle;
    private Integer autoPublishSettingPeriod;
    private Byte autoPublishSettingDay;
    private LocalTime autoPublishSettingTime;
    private Byte autoCancelSettingCount;
    private Integer autoCancelSettingTime;
}
