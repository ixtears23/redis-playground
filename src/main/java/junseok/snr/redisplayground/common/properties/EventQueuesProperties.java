package junseok.snr.redisplayground.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter @Setter
@ConfigurationProperties(prefix = "events.queues")
public class EventQueuesProperties {
    private String userCreatedByNameQueue;
    private String userCreatedRecordQueue;
    private String userCreatedEventTypeQueue;
}
