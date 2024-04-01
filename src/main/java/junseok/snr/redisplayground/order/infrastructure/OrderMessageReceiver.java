package junseok.snr.redisplayground.order.infrastructure;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderMessageReceiver {

    @SqsListener("DemoMainQueue")
    public void receiveMessage(String message, @Header(value = "SendId", required = false) String senderId) {
        log.info("=== Received Message : {} from senderId : {}", message, senderId);
    }


    // TODO @SqsListener 가 아닌, 직접 수신 받고, 로직 처리 후, 메시지 삭제, DLQ 전송되도록 강제 실패 및 DLQ 직접 전송
}
