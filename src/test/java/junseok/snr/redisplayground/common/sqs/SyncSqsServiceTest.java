package junseok.snr.redisplayground.common.sqs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SyncSqsServiceTest {
    @Autowired
    private SyncSqsService syncSqsService;
    @Autowired
    private SqsClient sqsClient;

    @DisplayName("sqs queue 목록을 프린트 한다.")
    @Test
    void printQueueListTest() {
        syncSqsService.printQueueList();
    }

    @DisplayName("sqs queue 목록이 비어있지 않아야 한다.")
    @Test
    void getQueuesTest() {
        final List<String> queues = syncSqsService.getQueues();
        assertThat(queues).isNotEmpty();
    }

    @DisplayName("sqs queue 를 생성하고 queueName으로 생성한 queue url이 조회되어야 한다.")
    @Test
    void createQueueAndGetQueueUrlTest() {

        final String queueName = "testQueue";
        final String createdQueueUrl = syncSqsService.createQueue(queueName);

        final String queueUrl = syncSqsService.getQueueUrl(queueName);

        assertThat(createdQueueUrl).isEqualTo(queueUrl);
    }
    
    @DisplayName("sqs queue에 메세지가 성공적으로 전송되어야 한다.")
    @Test
    void sendBatchMessagesTest() {

        final String queueUrl = "https://sqs.ap-northeast-2.amazonaws.com/058264072596/testQueue";

        final SendMessageBatchRequest sendMessageBatchRequest = SendMessageBatchRequest.builder()
                .queueUrl(queueUrl)
                .entries(
                        SendMessageBatchRequestEntry.builder()
                                .id("id1")
                                .messageBody("message001")
                                .build(),
                        SendMessageBatchRequestEntry.builder()
                                .id("id3")
                                .messageBody("message002")
                                .delaySeconds(10)
                                .build()
                )
                .build();

        syncSqsService.sendBatchMessages(sendMessageBatchRequest);
    }

    @DisplayName("sqs 대기열에 메세지 전송")
    @Test
    void sendSqsQueueTest() {
        final String queueName = "send-message-queue";
        syncSqsService.createQueue(queueName);

        final String queueUrl = syncSqsService.getQueueUrl(queueName);

        final SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody("good job!")
                .delaySeconds(5)
                .build();

        sqsClient.sendMessage(sendMessageRequest);

    }

}