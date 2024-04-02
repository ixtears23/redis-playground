package junseok.snr.redisplayground;

import io.awspring.cloud.sqs.annotation.SqsListener;
import junseok.snr.redisplayground.common.properties.EventQueuesProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SqsException;
import software.amazon.awssdk.services.sqs.paginators.ListQueuesIterable;

@Slf4j
@EnableConfigurationProperties(EventQueuesProperties.class)
@SpringBootApplication
public class RedisPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisPlaygroundApplication.class, args);

        SqsClient sqsClient = SqsClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .build();

        listQueues(sqsClient);
        sqsClient.close();
    }

    public static void listQueues(SqsClient sqsClient) {
        try {
            ListQueuesIterable listQueues = sqsClient.listQueuesPaginator();
            listQueues.stream()
                    .flatMap(r -> r.queueUrls().stream())
                    .forEach(content -> log.info(" Queue URL: {}", content.toLowerCase()));

        } catch (SqsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }


    @SqsListener("myQueue")
    public void listen(String message) {
        System.out.println(message);
    }
}
