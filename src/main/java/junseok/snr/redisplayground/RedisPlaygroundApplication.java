package junseok.snr.redisplayground;

import io.awspring.cloud.sqs.annotation.SqsListener;
import junseok.snr.redisplayground.common.properties.EventQueuesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(EventQueuesProperties.class)
@SpringBootApplication
public class RedisPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisPlaygroundApplication.class, args);
    }


    @SqsListener("myQueue")
    public void listen(String message) {
        System.out.println(message);
    }
}
