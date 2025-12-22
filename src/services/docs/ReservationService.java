package services.docs;

import application.domain.entities.Reservation;

import java.math.BigDecimal;

public interface ReservationService {
    void createReservation();
    String confirmReservation(long reservationId);
    void cancelReservation(long reservationId);
    double calculateEstimatedCost();
}
