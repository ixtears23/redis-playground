package junseok.snr.redisplayground.order.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import junseok.snr.redisplayground.order.application.OrderDto;
import junseok.snr.redisplayground.order.application.OrderService;
import junseok.snr.redisplayground.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) throws JsonProcessingException {
        final Order order = Order.from(orderDto);

        Order newOrder = orderService.createOrder(order);
        orderService.sendOrderMessage(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
}