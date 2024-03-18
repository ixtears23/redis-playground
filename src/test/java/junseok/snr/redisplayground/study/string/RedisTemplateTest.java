package junseok.snr.redisplayground.study.string;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.assertj.core.api.Assertions.assertThat;
@DataRedisTest
class RedisTemplateTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void testRedisOperations() {
        final String key = "Test Key";
        final String value = "Test Value";

        redisTemplate.opsForValue().set(key, value);

        String fetchedValue = redisTemplate.opsForValue().get(key);

        assertThat(fetchedValue).isEqualTo(value);
    }
}
