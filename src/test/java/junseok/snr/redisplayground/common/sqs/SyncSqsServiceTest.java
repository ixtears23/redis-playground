package junseok.snr.redisplayground.common.sqs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SyncSqsServiceTest {
    @Autowired
    private SyncSqsService syncSqsService;

    @Test
    void printQueueListTest() {
        syncSqsService.printQueueList();
    }

}