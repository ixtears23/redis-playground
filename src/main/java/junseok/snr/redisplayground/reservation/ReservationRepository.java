package junseok.snr.redisplayground.reservation;


import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, String> {
}
