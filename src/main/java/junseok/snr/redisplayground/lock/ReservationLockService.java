package junseok.snr.redisplayground.lock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReservationLockService {

    private final LockService lockService;
    private static final String LOCK_KEY_TEMPLATE = "class_lock_%s";

    public boolean makeReservation(String classId) {
        log.info("=== 예약처리 시작");
        final String lockKey = LOCK_KEY_TEMPLATE.formatted(classId);
        if (!lockService.acquireLock(lockKey, 10)) {
            log.info("=== lock 획득 실패 - lockKey : {}", lockKey);
            return false;
        }

        try {
            log.info("=== 예약 처리중...");

        } finally {
            lockService.releaseLock(lockKey);
            log.info("=== lock 해제 - lockKey : {}", lockKey);
        }

        log.info("=== 예약처리 종료");
        return true;
    }
}
