package junseok.snr.redisplayground.sqs;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import junseok.snr.redisplayground.common.properties.EventQueuesProperties;
import junseok.snr.redisplayground.user.application.UserCreatedEvent;
import junseok.snr.redisplayground.user.infrastructure.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.UUID;

import static org.awaitility.Awaitility.await;

class SpringCloudAwsSQSLiveTest extends BaseSqsIntegrationTest {

    @Autowired
    private SqsTemplate sqsTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventQueuesProperties eventQueuesProperties;

    @Test
    void givenAStringPayload_whenSend_shouldReceive() {
        var userName = "junseok";

        sqsTemplate.send(to -> to.queue(eventQueuesProperties.getUserCreatedByNameQueue())
                .payload(userName));

        await().atMost(Duration.ofSeconds(3))
                .until(() -> userRepository.findByName(userName)
                                .isPresent());
    }

    @Test
    void givenARecordPayload_whenSend_shouldReceive() {
        String userId = UUID.randomUUID().toString();

        var payload = new UserCreatedEvent(userId, "JunseokOh", "ixtears@naver.com");

        sqsTemplate.send(to -> to.queue(eventQueuesProperties.getUserCreatedRecordQueue()).payload(payload));

        await().atMost(Duration.ofSeconds(3))
                .until(() -> userRepository.findById(userId).isPresent());
    }



}
