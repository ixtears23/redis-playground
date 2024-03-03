package junseok.snr.redisplayground.groupclass.domain;

import junseok.snr.redisplayground.groupclass.application.dto.GroupClassSettingDto;
import org.springframework.stereotype.Component;

@Component
public class GroupClassSettingMapper {
    public GroupClassSetting groupClassSettingTo(GroupClassSettingDto groupClassSetting) {
        return GroupClassSetting.builder()
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
