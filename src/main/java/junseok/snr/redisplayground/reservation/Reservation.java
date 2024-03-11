package junseok.snr.redisplayground.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@RedisHash(value = "reservations", timeToLive = 300L)
public class Reservation {
    @Id
    private String id;
    @Indexed
    private String name;
    private String roomNumber;
}
