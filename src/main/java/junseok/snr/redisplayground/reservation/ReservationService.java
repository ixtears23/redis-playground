package junseok.snr.redisplayground.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public void saveOrUpdateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public Reservation findReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public void deleteReservationById(String id) {
        reservationRepository.deleteById(id);
    }

}