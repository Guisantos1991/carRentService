package application.domain.entities;

import application.domain.enums.ReservationStatus;

import java.math.BigDecimal;

public class Reservation {
    private Long id;
    private Customer customer;
    private Vehicle vehicle;
    private Branch pickupBranch;
    private Branch returnBranch;
    private String pickupDate;
    private String returnDate;
    private BigDecimal estimatedCost;
    private ReservationStatus status;

    public Reservation(Long id, Customer customer, Vehicle vehicle, Branch pickupBranch, Branch returnBranch, String pickupDate, String returnDate, BigDecimal estimatedCost, ReservationStatus status) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.pickupBranch = pickupBranch;
        this.returnBranch = returnBranch;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.estimatedCost = estimatedCost;
        this.status = status;
    }

    public void confirm() {
        this.status = ReservationStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = ReservationStatus.CANCELLED;
    }

    public void complete() {
        this.status = ReservationStatus.COMPLETED;
    }

    public BigDecimal getEstimatedCost(Double dailyRate, int rentalDays) {
        BigDecimal estimatedCost = BigDecimal.valueOf(dailyRate * rentalDays);

        return this.estimatedCost = estimatedCost;
    }

    public Long getId() {
        return id;
    }
}
