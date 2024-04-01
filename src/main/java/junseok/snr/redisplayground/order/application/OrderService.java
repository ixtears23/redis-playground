package junseok.snr.redisplayground.order.application;

import junseok.snr.redisplayground.order.domain.Order;

public interface OrderService {
    Order createOrder(Order order);
    void sendOrderMessage(Order order);
}
