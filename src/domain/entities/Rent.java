package domain.entities;

import domain.enums.RentStatus;

import java.util.Date;

public class Rent {
    private Integer id;
    private Reserve reserve;
    private Vehicle vehicle;
    private Client client;
    private Date pickupDate;
    private Date returnDate;
    private Long initialKm;
    private Long finalKm;
    private Double dailyRate;
    private Double totalValue;
    private RentStatus status;

    public Rent(Integer id, Reserve reserve, Vehicle vehicle, Client client, Date pickupDate, Date returnDate, Long initialKm, Long finalKm, Double dailyRate, Double totalValue, RentStatus status) {
        this.id = id;
        this.reserve = reserve;
        this.vehicle = vehicle;
        this.client = client;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.initialKm = initialKm;
        this.finalKm = finalKm;
        this.dailyRate = dailyRate;
        this.totalValue = totalValue;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Long getInitialKm() {
        return initialKm;
    }

    public void setInitialKm(Long initialKm) {
        this.initialKm = initialKm;
    }

    public Long getFinalKm() {
        return finalKm;
    }

    public void setFinalKm(Long finalKm) {
        this.finalKm = finalKm;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public RentStatus getStatus() {
        return status;
    }

    public void setStatus(RentStatus status) {
        this.status = status;
    }
}
