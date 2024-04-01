package junseok.snr.redisplayground.user.infrastructure;

import io.awspring.cloud.sqs.annotation.SqsListener;
import junseok.snr.redisplayground.user.application.UserCreatedEvent;
import junseok.snr.redisplayground.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static io.awspring.cloud.sqs.listener.SqsHeaders.MessageSystemAttributes.SQS_APPROXIMATE_FIRST_RECEIVE_TIMESTAMP;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserEventListeners {
    public static final String EVENT_TYPE_CUSTOM_HEADER = "eventType";
    private final UserRepository userRepository;

    @SqsListener("${events.queues.user-created-by-name-queue}")
    public void receiveStringMessage(String username) {
        log.info("=== Received message : {}", username);
        userRepository.save(
                new User(
                        UUID.randomUUID().toString(),
                        username,
                        null
                )
        );
    }

    @SqsListener(value = "${events.queues.user-created-record-queue}")
    public void receiveRecordMessage(UserCreatedEvent userCreatedEvent) {
        log.info("Received message : {}", userCreatedEvent);
        userRepository.save(
                new User(
                        userCreatedEvent.id(),
                        userCreatedEvent.username(),
                        userCreatedEvent.email()
                )
        );
    }

    @SqsListener("${events.queues.user-created-event-type-queue}")
    public void customHeaderMessage(Message<UserCreatedEvent> message,
                                    @Header(EVENT_TYPE_CUSTOM_HEADER) String eventType,
                                    @Header(SQS_APPROXIMATE_FIRST_RECEIVE_TIMESTAMP) Long firstReceive) {
        log.info("=== Received message {} with event type {}. First received at approximately {}.", message, eventType, firstReceive);
        final UserCreatedEvent payload = message.getPayload();
        userRepository.save(
                new User(
                        payload.id(),
                        payload.username(),
                        payload.email()
                )
        );

    }



}
