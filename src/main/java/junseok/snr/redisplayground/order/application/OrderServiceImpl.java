package junseok.snr.redisplayground.order.application;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import junseok.snr.redisplayground.order.domain.Status;
import junseok.snr.redisplayground.order.infrastructure.OrderRepository;
import junseok.snr.redisplayground.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final SqsTemplate sqsTemplate;

    @Transactional
    public Order createOrder(Order order) {
        order.setStatus(Status.CREATED);
        order.setOrderDateTime(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public void sendOrderMessage(Order order) {
        final String queueName = "DemoMainQueue";
        sqsTemplate.send(queueName, order);
    }
}