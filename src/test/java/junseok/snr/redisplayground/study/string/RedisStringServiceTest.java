package junseok.snr.redisplayground.study.string;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RedisStringServiceTest {
    @Autowired
    private RedisStringService redisStringService;

    @Test
    void setValue() {
        final String key = "junseok";
        final String value = "value";
        redisStringService.setValue(key, value);

        final String actual = redisStringService.getValue(key);

        assertThat(actual).isEqualTo(value);
    }

}