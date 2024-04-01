package junseok.snr.redisplayground.order.infrastructure;

import junseok.snr.redisplayground.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
