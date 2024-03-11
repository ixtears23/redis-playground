package junseok.snr.redisplayground.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createOrUpdateReservation(@RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.saveOrUpdateReservation(reservation);
        return ResponseEntity.ok(savedReservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable String id) {
        Reservation reservation = reservationService.findReservationById(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
        reservationService.deleteReservationById(id);
        return ResponseEntity.ok().build();
    }
}
