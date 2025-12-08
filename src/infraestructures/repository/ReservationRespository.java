package infraestructures.repository;

import application.domain.entities.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReservationRespository {

    private final Map<Long, Reservation> reservations;

    public ReservationRespository(Map<Long, Reservation> reservations) {
        this.reservations = reservations;
    }

    public void save(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }

    public void findById(Long reservationId) {
        reservations.get(reservationId);
    }

    public List<Reservation> findAll() {
        return new ArrayList<>(reservations.values());
    }
}
