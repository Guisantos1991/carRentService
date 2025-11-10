package domain.entities;

import domain.enums.ReserveStatus;

import java.util.Date;

public class Reserve {
    private Integer id;
    private Client client;
    private Vehicle vehicle;
    private Branch pickupBranch;
    private Branch returnBranch;
    private Date pickupDate;
    private Date returnDate;
    private Double estimatedTotal;
    private ReserveStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Branch getPickupBranch() {
        return pickupBranch;
    }

    public void setPickupBranch(Branch pickupBranch) {
        this.pickupBranch = pickupBranch;
    }

    public Branch getReturnBranch() {
        return returnBranch;
    }

    public void setReturnBranch(Branch returnBranch) {
        this.returnBranch = returnBranch;
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

    public Double getEstimatedTotal() {
        return estimatedTotal;
    }

    public void setEstimatedTotal(Double estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public ReserveStatus getStatus() {
        return status;
    }

    public void setStatus(ReserveStatus status) {
        this.status = status;
    }

    public Reserve(Integer id, Client client, Vehicle vehicle, Branch pickupBranch, Branch returnBranch, Date pickupDate, Date returnDate, Double estimatedTotal, ReserveStatus status) {
        this.id = id;
        this.client = client;
        this.vehicle = vehicle;
        this.pickupBranch = pickupBranch;
        this.returnBranch = returnBranch;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.estimatedTotal = estimatedTotal;
        this.status = status;
    }
}
