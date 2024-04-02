package junseok.snr.redisplayground.common.sqs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.paginators.ListQueuesIterable;

@Slf4j
@RequiredArgsConstructor
@Service
public class SyncSqsService implements SqsService {
    private final SqsClient sqsClient;

    @Override
    public void printQueueList() {
        final ListQueuesIterable listQueuesIterable = sqsClient.listQueuesPaginator();

        listQueuesIterable.stream()
                .flatMap(listQueuesResponse -> listQueuesResponse.queueUrls().stream())
                .forEach(content -> log.info("=== queue URL : {}", content.toLowerCase()));
    }
}
