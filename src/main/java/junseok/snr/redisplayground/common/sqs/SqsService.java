package junseok.snr.redisplayground.common.sqs;

import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequest;

import java.util.List;

public interface SqsService {
    void printQueueList();

    List<String> getQueues();

    String createQueue(String queueName);

    String getQueueUrl(String queueName);

    void sendBatchMessages(SendMessageBatchRequest sendMessageBatchRequest);
}
