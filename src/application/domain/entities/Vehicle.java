package application.domain.entities;

import application.domain.enums.FuelType;
import application.domain.enums.TransmissionType;
import application.domain.enums.VehicleCategory;
import application.domain.enums.VehicleStatus;

public class Vehicle {
    private Long id;
    private String plateNumber;
    private String model;
    private Integer year;
    private Integer currentKm;
    private FuelType fuelType;
    private TransmissionType transmissionType;
    private VehicleCategory category;
    private VehicleStatus vehicleStatus;
    private Double dailyRate;
    private Branch branch;

    public Vehicle(Long id, String plateNumber, String model, Integer year, Integer currentKm, FuelType fuelType, TransmissionType transmissionType, VehicleCategory category, VehicleStatus vehicleStatus, Double dailyRate, Branch branch) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.model = model;
        this.year = year;
        this.currentKm = currentKm;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.category = category;
        this.vehicleStatus = vehicleStatus;
        this.dailyRate = dailyRate;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getCurrentKm() {
        return currentKm;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public VehicleCategory getCategory() {
        return category;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public void reserve() {
        this.vehicleStatus = VehicleStatus.RESERVED;
    }

    public void release() {
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public void markAsRented() {
        this.vehicleStatus = VehicleStatus.RENTED;
    }

    public void sendToMaintenance() {
        this.vehicleStatus = VehicleStatus.IN_MAINTENANCE;
    }

    public void updateKm(int additionalKm) {
        this.currentKm += additionalKm;
    }

    public void setVehicleStatus(VehicleStatus status) {
        this.vehicleStatus = status;
    }

    public Branch getBranch() { return branch; }

    public void setBranch(Branch branch) { this.branch = branch; }
}
