package junseok.snr.redisplayground.groupclass.application.dto;

import junseok.snr.redisplayground.groupclass.domain.GroupClassSetting;
import org.springframework.stereotype.Component;

@Component
public class GroupClassSettingDtoMapper {
    public GroupClassSettingDto groupClassSettingDtoTo(GroupClassSetting groupClassSetting) {
        return GroupClassSettingDto.builder()
                .seqGroupClassSetting(groupClassSetting.getSeqGroupClassSetting())
                .autoPublishSettingType(groupClassSetting.getAutoPublishSettingType())
                .autoPublishSettingCycle(groupClassSetting.getAutoPublishSettingCycle())
                .autoPublishSettingPeriod(groupClassSetting.getAutoPublishSettingPeriod())
                .autoPublishSettingDay(groupClassSetting.getAutoPublishSettingDay())
                .autoPublishSettingTime(groupClassSetting.getAutoPublishSettingTime())
                .autoCancelSettingCount(groupClassSetting.getAutoCancelSettingCount())
                .autoCancelSettingTime(groupClassSetting.getAutoCancelSettingTime())
                .build();
    }
}
