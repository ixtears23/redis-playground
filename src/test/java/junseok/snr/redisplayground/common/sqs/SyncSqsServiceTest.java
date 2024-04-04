package junseok.snr.redisplayground.common.sqs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequestEntry;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SyncSqsServiceTest {
    @Autowired
    private SyncSqsService syncSqsService;

    @Test
    void printQueueListTest() {
        syncSqsService.printQueueList();
    }

    @Test
    void getQueuesTest() {
        syncSqsService.getQueues();
    }

    @Test
    void createQueueAndGetQueueUrlTest() {

        final String queueName = "testQueue";
        final String createdQueueUrl = syncSqsService.createQueue(queueName);

        final String queueUrl = syncSqsService.getQueueUrl(queueName);

        assertThat(createdQueueUrl).isEqualTo(queueUrl);
    }

    @Test
    void sendBatchMessagesTest() {

        final String queueUrl = "https://sqs.ap-northeast-2.amazonaws.com/419547990266/DemoMainQueue";


        final SendMessageBatchRequest sendMessageBatchRequest = SendMessageBatchRequest.builder()
                .queueUrl(queueUrl)
                .entries(
                        SendMessageBatchRequestEntry.builder().id("id1").messageBody("message001").build(),
                        SendMessageBatchRequestEntry.builder().id("id2").messageBody("message002").delaySeconds(10).build()
                )
                .build();

        syncSqsService.sendBatchMessages(sendMessageBatchRequest);
    }

}