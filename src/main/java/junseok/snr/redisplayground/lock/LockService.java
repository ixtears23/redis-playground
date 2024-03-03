package junseok.snr.redisplayground.lock;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class LockService {
    private final RedisTemplate<String, String > redisTemplate;

    public boolean acquireLock(String lockKey, long expireTime) {
        final Boolean success = redisTemplate.opsForValue().setIfAbsent(lockKey, "locked", expireTime, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(success);
    }

    public void releaseLock(String lockKey) {
        redisTemplate.delete(lockKey);
    }

}
