package domain.interfaces.services;

import domain.entities.Payment;
import domain.enums.PaymentMethod;

public interface PaymentService {
    Payment authorization(Integer rentId, Double value, String currency, PaymentMethod paymentMethod);
    Void capture(Integer paymentId);
    Void reversed(Integer paymentId, String motive);
}
