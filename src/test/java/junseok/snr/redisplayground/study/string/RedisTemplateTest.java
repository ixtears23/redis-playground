package junseok.snr.redisplayground.study.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.assertj.core.api.Assertions.assertThat;
@DataRedisTest
class RedisTemplateTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @DisplayName("Redis 키를 생성한 뒤에, 생성한 Key 이름으로 조회 되어야 한다.")
    @Test
    void testRedisOperations() {
        final String key = "Test Key";
        final String value = "Test Value";

        redisTemplate.opsForValue().set(key, value);

        String fetchedValue = redisTemplate.opsForValue().get(key);

        assertThat(fetchedValue).isEqualTo(value);
    }
}
