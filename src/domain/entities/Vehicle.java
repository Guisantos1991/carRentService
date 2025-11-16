package domain.entities;

import com.sun.jdi.connect.Transport;
import domain.enums.FuelType;
import domain.enums.Transmission;
import domain.enums.VehicleCategory;
import domain.enums.VehicleStatus;

public class Vehicle {
    private Integer id;
    private String plate;
    private String brand;
    private String model;
    private Integer year;
    private VehicleCategory category;
    private Transmission transmission;
    private FuelType fuelType;
    private Long odometerReading;
    private VehicleStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public VehicleCategory getCategory() {
        return category;
    }

    public void setCategory(VehicleCategory category) {
        this.category = category;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Long getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(Long odometerReading) {
        this.odometerReading = odometerReading;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public Vehicle(Integer id, String plate, String brand, String model, Integer year, VehicleCategory category, Transmission transmission, FuelType fuelType, Long odometerReading, VehicleStatus status) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.category = category;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.odometerReading = odometerReading;
        this.status = status;
    }

    public void reserve() {
        this.status = VehicleStatus.RESERVED;
    }

    public void release() {
        this.status = VehicleStatus.AVAILABLE;
    }

    public void markAsRented() {
        this.status = VehicleStatus.RENTED;
    }

    public void sendToMaintenance() {
        this.status = VehicleStatus.IN_MAINTENANCE;
    }

    public void markAsUnavailable() {
        this.status = VehicleStatus.UNAVAILABLE;
    }
}
