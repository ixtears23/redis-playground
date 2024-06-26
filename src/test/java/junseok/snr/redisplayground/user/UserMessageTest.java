package junseok.snr.redisplayground.user;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import junseok.snr.redisplayground.common.properties.EventQueuesProperties;
import junseok.snr.redisplayground.sqs.BaseSqsIntegrationTest;
import junseok.snr.redisplayground.user.application.UserCreatedEvent;
import junseok.snr.redisplayground.user.infrastructure.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.Map;
import java.util.UUID;

import static junseok.snr.redisplayground.user.infrastructure.UserEventListeners.EVENT_TYPE_CUSTOM_HEADER;
import static org.awaitility.Awaitility.await;

class UserMessageTest extends BaseSqsIntegrationTest {

    @Autowired
    private SqsTemplate sqsTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventQueuesProperties eventQueuesProperties;

    @Test
    void userCreatedByNameQueueTest() {
        var userName = "junseok";

        sqsTemplate.send(to -> to.queue(eventQueuesProperties.getUserCreatedByNameQueue())
                .payload(userName));

        await().atMost(Duration.ofSeconds(3))
                .until(() -> userRepository.findByName(userName)
                                .isPresent());
    }

    @Test
    void userCreatedRecordQueueTest() {
        String userId = UUID.randomUUID().toString();

        var payload = new UserCreatedEvent(userId, "JunseokOh", "ixtears@naver.com");

        sqsTemplate.send(to -> to.queue(eventQueuesProperties.getUserCreatedRecordQueue()).payload(payload));

        await().atMost(Duration.ofSeconds(3))
                .until(() -> userRepository.findById(userId).isPresent());
    }

    @Test
    void userCreatedEventTypeQueueTest() {
        String userId = UUID.randomUUID().toString();

        final var payload = new UserCreatedEvent(userId, "Oh", "ixtears@naver.com");
        final var headers = Map.<String, Object> of(EVENT_TYPE_CUSTOM_HEADER, "UserCreatedEvent");

        sqsTemplate.send(to -> to.queue(eventQueuesProperties.getUserCreatedEventTypeQueue())
                .payload(payload)
                .headers(headers));

        await().atMost(Duration.ofSeconds(3))
                .until(() -> userRepository.findById(userId)
                        .isPresent());



    }



}
