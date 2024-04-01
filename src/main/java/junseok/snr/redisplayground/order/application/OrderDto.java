package junseok.snr.redisplayground.order.application;

import junseok.snr.redisplayground.order.domain.Status;

import java.time.LocalDateTime;

public record OrderDto(
        Long id,
        String customerName,
        String orderDetails,
        LocalDateTime orderDateTime,
        Status status
) {}