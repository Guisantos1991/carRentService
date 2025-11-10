package domain.interfaces.services;

import domain.enums.ReserveStatus;

import java.util.Date;

public interface AvailabilityService {
    Boolean vehicleAvailability(Integer vehicleId, String pickupBranch, Date pickupDate, Date returnDate, ReserveStatus reserveStatus);
    String suggestedVehicle(Integer categoryId, Date pickupDate, Date returnDate);
}
