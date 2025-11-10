package domain.interfaces.repository;

import domain.entities.Payment;
import domain.enums.RentStatus;
import domain.enums.ReserveStatus;

import java.util.Optional;

public interface PaymentRepository {
    Optional<Payment> findById(Integer id);
    Void save(Payment payment);
    Void updateStatus(Integer id, ReserveStatus status, RentStatus rentStatus, Payment transactionId);
}
