package services;

import infraestructures.repository.CustomerRepository;
import infraestructures.repository.VehicleRepository;

public class VehicleServiceImpl implements VehicleService {

    private final CustomerRepository customerRepository;

    public VehicleServiceImpl(VehicleRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public void registerVehicle() {

    }

    @Override
    public void updateVehicle() {

    }

    @Override
    public void changeVehicleStatus() {

    }

    @Override
    public void findAvailableVehicles() {

    }
}
