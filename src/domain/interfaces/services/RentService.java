package domain.interfaces.services;

import java.util.Date;

public interface RentService {
    Void pickupRegister(Integer rentId, Long initialKm, Date pickupDate);
    Void returnRegister(Integer rentId, Long finalKm, Date returnDate);

}
