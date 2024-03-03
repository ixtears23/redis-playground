package junseok.snr.redisplayground.groupclass.application.service;

import junseok.snr.redisplayground.groupclass.domain.GroupClassSetting;

import java.util.Optional;

public interface GroupClassSettingService {
    GroupClassSetting create(GroupClassSetting groupClassSetting);
    GroupClassSetting update(GroupClassSetting groupClassSetting);
    void delete(int id);
    Optional<GroupClassSetting> findById(int id);
}
