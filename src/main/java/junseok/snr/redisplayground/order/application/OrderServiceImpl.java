package junseok.snr.redisplayground.order.application;

import junseok.snr.redisplayground.order.infrastructure.OrderRepository;
import junseok.snr.redisplayground.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        order.setStatus("CREATED");
        order.setOrderDateTime(LocalDateTime.now());
        return orderRepository.save(order);
    }
}