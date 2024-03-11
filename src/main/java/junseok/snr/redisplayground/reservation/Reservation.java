package junseok.snr.redisplayground.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Reservation {
    private String id;
    private String name;
    private String roomNumber;
}
