package services.docs;

import application.domain.entities.Reservation;

import java.math.BigDecimal;

public interface ReservationService {
    void createReservation();
    Reservation confirmReservation(long reservationId);
    Reservation cancelReservation(long reservationId);
    BigDecimal calculateEstimatedCost(long reservationId, int rentalDays);
}
