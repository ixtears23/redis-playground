package junseok.snr.redisplayground.common.sqs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}