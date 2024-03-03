package junseok.snr.redisplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisPlaygroundApplication.class, args);
    }

}
