package junseok.snr.redisplayground.common.sqs;

import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;

public interface SqsService {
    void printQueueList();

    List<String> getQueues();

    String createQueue(String queueName);

    String getQueueUrl(String queueName);

    void sendBatchMessages(SendMessageBatchRequest sendMessageBatchRequest);

    void sendMessage(SendMessageRequest sendMessageRequest);

    List<String> receiveStringMessageList(ReceiveMessageRequest receiveMessageRequest);

    List<Message> receiveMessageList(String queueUrl, int maxNumberOfMessages);

    void deleteMessage(String queueUrl, String receiptHandle);
}
