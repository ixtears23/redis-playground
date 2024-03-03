package junseok.snr.redisplayground.groupclass.application.dto;

import jakarta.persistence.*;
import junseok.snr.redisplayground.groupclass.domain.AutoPublishSettingType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalTime;

@Builder
@Getter
@RedisHash(value = "group-class-setting")
public class GroupClassSettingDto {
    @Id
    private Integer seqGroupClassSetting;
    private AutoPublishSettingType autoPublishSettingType;
    private Integer autoPublishSettingCycle;
    private Integer autoPublishSettingPeriod;
    private Byte autoPublishSettingDay;
    private LocalTime autoPublishSettingTime;
    private Byte autoCancelSettingCount;
    private Integer autoCancelSettingTime;
}
