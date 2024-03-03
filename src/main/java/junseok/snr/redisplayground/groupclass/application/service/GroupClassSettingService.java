package junseok.snr.redisplayground.groupclass.application.service;

import junseok.snr.redisplayground.groupclass.application.dto.GroupClassSettingDto;
import junseok.snr.redisplayground.groupclass.domain.GroupClassSetting;

import java.util.Optional;

public interface GroupClassSettingService {
    GroupClassSettingDto create(GroupClassSettingDto groupClassSetting);
    GroupClassSettingDto update(GroupClassSettingDto groupClassSetting);
    void delete(int id);
    Optional<GroupClassSettingDto> findById(int id);
}
