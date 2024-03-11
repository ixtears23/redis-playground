package junseok.snr.redisplayground.reservation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RedisTemplate<String, String> redisTemplate;

    public Reservation saveOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation findReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public void deleteReservationById(String id) {
        reservationRepository.deleteById(id);
    }


    public void updateMultipleReservations(List<Reservation> reservations) {
        redisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> operations) throws DataAccessException {
                operations.multi();
                for (Reservation reservation : reservations) {
                    // 여기에서는 타입 캐스팅을 명시적으로 수행해야 합니다.
                    operations.opsForHash().put((K) "reservations", (K) reservation.getId(), (V) reservation);
                }
                return operations.exec();
            }
        });
    }


}
