package domain.interfaces.services;

import domain.entities.Rent;
import domain.entities.Reserve;

import java.util.Date;
import java.util.Optional;

public interface ReserveService {
    Reserve createReserve(Integer clientId,
                          Integer pickupBranch,
                          Integer returnBranch,
                          Date pickupDate,
                          Date returnDate
                          );
    Void setVehicle(Integer reserveId, Integer vehicleId);
    Void cancel(Integer reserveId, String motive);
    Optional<Rent> confirmPickup(Integer reserveId);
}
