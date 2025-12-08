package services.docs;

import application.domain.entities.Reservation;
import dto.CreateReservationRequest;

import java.math.BigDecimal;

public interface ReservationService {
    void createReservation(CreateReservationRequest request);
    Reservation confirmReservation(Long reservationId);
    Reservation cancelReservation(Long reservationId);
    BigDecimal calculateEstimatedCost(Long reservationId, int rentalDays);
}
