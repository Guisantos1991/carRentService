package services;

import application.domain.entities.Customer;
import application.domain.entities.Reservation;
import application.domain.entities.Vehicle;
import infraestructures.repository.CustomerRepository;
import infraestructures.repository.VehicleRepository;
import services.docs.ReservationService;

import java.math.BigDecimal;

public class ReservationServiceImpl implements ReservationService {
    private VehicleRepository vehicleRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createReservation() {
        System.out.println("===== Reserva =====");


    }

    @Override
    public Reservation confirmReservation(long reservationId) {
        return null;


    }

    @Override
    public Reservation cancelReservation(long reservationId) {
        return null;
    }

    @Override
    public BigDecimal calculateEstimatedCost(long reservationId, int rentalDays) {
        return null;
    }
}
