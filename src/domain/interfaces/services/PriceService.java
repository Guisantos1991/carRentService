package domain.interfaces.services;

import java.util.Date;

public interface PriceService {
    Double estimatedPrice(Integer vehicleId, Date pickupDate, Date returnDate);
    Double totalValue(Integer rentId, Long totalTravelDistance, boolean fuel);

}
