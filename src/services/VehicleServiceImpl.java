package services;

import application.domain.entities.Customer;
import application.domain.entities.Vehicle;
import application.domain.enums.*;
import infraestructures.repository.CustomerRepository;
import infraestructures.repository.VehicleRepository;
import services.docs.VehicleService;

public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository = new VehicleRepository();

    @Override
    public void registerVehicle() {
        System.out.println("\n=== CADASTRO DE CLIENTE ===");
        System.out.print("ID Veículo: ");
        Long id = Long.parseLong(System.console().readLine());

        System.out.print("Placa: ");
        String plateNumber = System.console().readLine();

        System.out.print("Modelo: ");
        String model = System.console().readLine();

        System.out.print("Ano: ");
        Integer year = Integer.parseInt(System.console().readLine());

        System.out.print("Kilometragem: ");
        Integer currentKm = Integer.parseInt(System.console().readLine());

        System.out.print("Tipo de Combustível (GASOLINE/ FLEX / ETHANOL/ DIESEL/ ELECTRIC/ HYBRID): ");
        FuelType fuelType = FuelType.valueOf(System.console().readLine().toUpperCase());

        System.out.print("Tipo de Transmissão (MANUAL/ AUTOMÁTICA): ");
        TransmissionType transmissionType = TransmissionType.valueOf(System.console().readLine().toUpperCase());

        System.out.print("Categoria (ECONOMY/ COMPACT/ SUV/ LUXURY/ VAN): ");
        VehicleCategory category = VehicleCategory.valueOf(System.console().readLine().toUpperCase());

        System.out.print("Valor Diário: ");
        Double dailyRate = Double.parseDouble(System.console().readLine());

        Vehicle vehicle = new Vehicle(
            id,
            plateNumber,
            model,
            year,
            currentKm,
            fuelType,
            transmissionType,
            category,
            VehicleStatus.AVAILABLE,
            dailyRate
        );

        vehicleRepository.save(vehicle);

        System.out.println("✅ Veículo cadastrado com sucesso!");
    }

    @Override
    public void updateVehicle() {
        System.out.println("\n=== ATUALIZAÇÃO DE VEÍCULO ===");
        System.out.print("ID do Veículo a ser atualizado: ");
        Long id = Long.parseLong(System.console().readLine());
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            System.out.println("❌ Veículo não encontrado!");
            return;
        }
        System.out.print("Novo Modelo (atual: " + vehicle.getModel() + "): ");
        String model = System.console().readLine();
        System.out.print("Novo Ano (atual: " + vehicle.getYear() + "): ");
        Integer year = Integer.parseInt(System.console().readLine());
        System.out.print("Nova Kilometragem (atual: " + vehicle.getCurrentKm() + "): ");
        Integer currentKm = Integer.parseInt(System.console().readLine());
        vehicle = new Vehicle(
            vehicle.getId(),
            vehicle.getPlateNumber(),
            model,
            year,
            currentKm,
            vehicle.getFuelType(),
            vehicle.getTransmissionType(),
            vehicle.getCategory(),
            vehicle.getVehicleStatus(),
            vehicle.getDailyRate()
        );
        vehicleRepository.save(vehicle);
        System.out.println("✅ Veículo atualizado com sucesso!");
    }

    @Override
    public void changeVehicleStatus() {
        System.out.println("\n=== ALTERAÇÃO DE STATUS DO VEÍCULO ===");
        System.out.print("ID do Veículo: ");
        Long id = Long.parseLong(System.console().readLine());
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle == null) {
            System.out.println("❌ Veículo não encontrado!");
            return;
        }
        System.out.print("Novo Status (AVAILABLE/ RESERVED/ RENTED/ MAINTENANCE): ");
        VehicleStatus status = VehicleStatus.valueOf(System.console().readLine().toUpperCase());
        vehicle.setVehicleStatus(status);
    }

    @Override
    public void findAvailableVehicles() {
        vehicleRepository.findAll().forEach(vehicle -> {
            if (vehicle.getVehicleStatus() == VehicleStatus.AVAILABLE) {
                System.out.println("\n==== Veículo ====");
                System.out.println("ID: " + vehicle.getId());
                System.out.println("Placa: " + vehicle.getPlateNumber());
                System.out.println("Modelo: " + vehicle.getModel());
                System.out.println("Ano: " + vehicle.getYear());
                System.out.println("Tipo de Combustível: " + vehicle.getFuelType());
                System.out.println("Tipo de Transmissão: " + vehicle.getTransmissionType());
                System.out.println("Categoria: " + vehicle.getCategory());
            }
        });
    }
}
