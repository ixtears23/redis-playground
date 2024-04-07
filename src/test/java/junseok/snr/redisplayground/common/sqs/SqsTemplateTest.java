package junseok.snr.redisplayground.common.sqs;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsSendOptions;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;

import java.time.Duration;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SqsTemplateTest {
    private SqsTemplate sqsTemplate;

    @Autowired
    public SqsTemplateTest(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    @DisplayName("메세지를 전송해야 한다.")
    @Test
    void sendMessagePayloadTest() {
        sqsTemplate.send("send-message-queue", "{\"id\":1,\"name\":\"junseok\"}");
    }

    @DisplayName("메세지를 전송해야 한다.")
    @Test
    void sendMessageDelayTest() {
        sqsTemplate.send(sqsSendOptions -> sqsSendOptions.queue("send-message-queue")
                .payload("{\"id\":2,\"name\":\"junseok\"}"));
    }

    @Test
    void nothing() {
        final var queueName = "send-message-queue";
        final var firstMessage = "{\"id\":10,\"name\":\"junseok\"}";
        final var secondMessage = "{\"id\":20,\"name\":\"junseok\"}";

        final SendResult<Object> firstSendResult = sqsTemplate.send(sqsSendOptions -> sqsSendOptions.queue(queueName)
                .payload(firstMessage));

        final SendResult<Object> SecondSendResult = sqsTemplate.send(queueName, secondMessage);

        final UUID firstUuid = firstSendResult.messageId();
        final UUID secondUuid = SecondSendResult.messageId();


        final Message<?> receivedFirstMessage = sqsTemplate.receive(
                        sqsReceiveOptions -> sqsReceiveOptions.queue(queueName)
                                .maxNumberOfMessages(1)
                                .receiveRequestAttemptId(firstUuid)
                                .pollTimeout(Duration.ofSeconds(10))
                )
                .orElseThrow();


        final Message<?> receivedSecondMessage = sqsTemplate.receive(
                        sqsReceiveOptions -> sqsReceiveOptions.queue(queueName)
                                .maxNumberOfMessages(1)
                                .receiveRequestAttemptId(secondUuid)
                                .pollTimeout(Duration.ofSeconds(10))
                )
                .orElseThrow();

        assertThat(receivedFirstMessage.getPayload()).isEqualTo(firstMessage);
        assertThat(receivedSecondMessage.getPayload()).isEqualTo(secondMessage);




    }




}
