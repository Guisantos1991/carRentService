package services;

import application.domain.entities.Reservation;
import dto.CreateReservationRequest;
import services.docs.ReservationService;

import java.math.BigDecimal;

public class ReservationServiceImpl implements ReservationService {
    @Override
    public void createReservation(CreateReservationRequest request) {

    }

    @Override
    public Reservation confirmReservation(Long reservationId) {
        return null;
    }

    @Override
    public Reservation cancelReservation(Long reservationId) {
        return null;
    }

    @Override
    public BigDecimal calculateEstimatedCost(Long reservationId, int rentalDays) {
        return null;
    }
}
