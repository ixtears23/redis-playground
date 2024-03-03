package junseok.snr.redisplayground.groupclass.application.dto;

import junseok.snr.redisplayground.groupclass.domain.AutoPublishSettingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupClassSettingDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 42L;

    private Integer seqGroupClassSetting;
    private AutoPublishSettingType autoPublishSettingType;
    private Integer autoPublishSettingCycle;
    private Integer autoPublishSettingPeriod;
    private Byte autoPublishSettingDay;
    private LocalTime autoPublishSettingTime;
    private Byte autoCancelSettingCount;
    private Integer autoCancelSettingTime;
}
