package junseok.snr.redisplayground.common.sqs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;
import software.amazon.awssdk.services.sqs.paginators.ListQueuesIterable;

import java.util.List;

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

    @Override
    public List<String> getQueues() {
        final ListQueuesRequest listQueuesRequest = ListQueuesRequest.builder()
                .build();

        final ListQueuesResponse listQueuesResponse = sqsClient.listQueues(listQueuesRequest);
        final List<String> queueUrls = listQueuesResponse.queueUrls();

        log.info("=== getQueues : {}", queueUrls);
        return queueUrls;
    }

    @Override
    public String createQueue(String queueName) {
        final CreateQueueRequest createQueueRequest = CreateQueueRequest.builder()
                .queueName(queueName)
                .build();

        sqsClient.createQueue(createQueueRequest);

        return getQueueUrl(queueName);
    }

    @Override
    public String getQueueUrl(String queueName) {
        final GetQueueUrlResponse getQueueUrlResponse = sqsClient.getQueueUrl(GetQueueUrlRequest.builder()
                .queueName(queueName)
                .build());
        return getQueueUrlResponse.queueUrl();
    }

    @Override
    public void sendBatchMessages(SendMessageBatchRequest sendMessageBatchRequest) {

        sqsClient.sendMessageBatch(sendMessageBatchRequest);
    }

    @Override
    public void sendMessage(SendMessageRequest sendMessageRequest) {
        sqsClient.sendMessage(sendMessageRequest);
    }

    @Override
    public List<String> receiveStringMessageList(ReceiveMessageRequest receiveMessageRequest) {
        final List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();

        final List<String> messageList = messages.stream()
                .map(Message::body)
                .toList();

        messageList.forEach(messageBody -> log.info("=== received messageBody :: {}", messageBody));

        return messageList;
    }

    @Override
    public List<Message> receiveMessageList(String queueUrl, int maxNumberOfMessages) {
        log.info("=== receiveMessageList - queueUrl : {}, maxNumberOfMessages : {}", queueUrl, maxNumberOfMessages);
        final ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(maxNumberOfMessages)
                .waitTimeSeconds(3)
                .build();

        final List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();
        log.info("=== received Messages : {}", messages);

        return messages;
    }

    @Override
    public void deleteMessage(String queueUrl, String receiptHandle) {
        log.info("=== deleteMessage - queueUrl : {}, receiptHandle : {}", queueUrl, receiptHandle);
        final DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                .queueUrl(queueUrl)
                .receiptHandle(receiptHandle)
                .build();

        final DeleteMessageResponse deleteMessageResponse = sqsClient.deleteMessage(deleteMessageRequest);
        log.info("=== deletedMessage - {}", deleteMessageResponse);
    }


}
