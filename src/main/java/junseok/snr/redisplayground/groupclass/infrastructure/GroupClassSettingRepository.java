package junseok.snr.redisplayground.groupclass.infrastructure;

import junseok.snr.redisplayground.groupclass.domain.GroupClassSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupClassSettingRepository extends JpaRepository<GroupClassSetting, Integer> {
}
