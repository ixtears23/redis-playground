package junseok.snr.redisplayground.order.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import junseok.snr.redisplayground.order.domain.Order;

public interface OrderService {
    Order createOrder(Order order);
    void sendOrderMessage(Order order) throws JsonProcessingException;
}
