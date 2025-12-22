package services;

import application.domain.entities.Branch;
import application.domain.entities.Customer;
import application.domain.entities.Reservation;
import application.domain.entities.Vehicle;
import application.domain.enums.ReservationStatus;
import application.domain.enums.VehicleStatus;
import infraestructures.repository.BranchRepository;
import infraestructures.repository.CustomerRepository;
import infraestructures.repository.ReservationRespository;
import infraestructures.repository.VehicleRepository;
import services.docs.ReservationService;
import static java.lang.Long.parseLong;

public class ReservationServiceImpl implements ReservationService {
    private VehicleRepository vehicleRepository;
    private CustomerRepository customerRepository;
    private BranchRepository branchRepository;
    private ReservationRespository reservationRespository;

    public ReservationServiceImpl(VehicleRepository vehicleRepository, CustomerRepository customerRepository, BranchRepository branchRepository, ReservationRespository reservationRespository) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
        this.branchRepository = branchRepository;
        this.reservationRespository = reservationRespository;
    }

    @Override
    public void createReservation() {
        System.out.println("===== Reserva =====");
        System.out.print("ID do Cliente: ");
        Long customerId = parseLong(System.console().readLine());
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) {
            System.out.println("Cliente não encontrado.");
        }
        System.out.print("ID do Veiculo: ");
        long vehicleId = parseLong(System.console().readLine());
        Vehicle vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle == null) {
            System.out.println("Veiculo não encontrado.");
        }
        System.out.print("Local de Retirada: ");
        String pickupBranch = System.console().readLine();
        Branch pickBranch = branchRepository.findByName(pickupBranch);
        System.out.print("Local de Devolução: ");
        String returnBranch = System.console().readLine();
        Branch retBranch = branchRepository.findByName(returnBranch);
        System.out.print("Data de Retirada (DD/MM/AAAA): ");
        String pickupDate = System.console().readLine();
        System.out.print("Data de Devolução (DD/MM/AAAA): ");
        String returnDate = System.console().readLine();
        assert vehicle != null;
        if(vehicle.getVehicleStatus() == VehicleStatus.AVAILABLE){
            Reservation reservation = new Reservation(customer, vehicle, pickBranch, retBranch, pickupDate, returnDate, vehicle.getDailyRate(), ReservationStatus.CREATED);
            System.out.println("Reserva criada com sucesso!");
            System.out.println("ID da Reserva: " + reservation.getId());
            reservationRespository.save(reservation);
            vehicle.setVehicleStatus(VehicleStatus.RESERVED);
        } else {
            System.out.println("Veiculo indisponível para reserva.Favor verificar lista de veículos.");
        }
    }

    @Override
    public String confirmReservation(long reservationId) {

        System.out.println("===== Confirmação de Reserva =====");
        Reservation reservation = reservationRespository.findById(reservationId);
        if (reservation == null) {
            return "Reserva não encontrada.";
        }
        System.out.println("Confirme seu acesso de funcionário: ");
        long employeeNum = parseLong(System.console().readLine());
        if (employeeNum > 0) {
            reservation.confirm();
            return "Reserva confirmada com sucesso!";
        } else {
            return "Número de funcionário inválido. Confirmação falhou.";
        }


    }

    @Override
    public void cancelReservation(long reservationId) {
        System.out.println("===== Cancelamento de Reserva =====");
        Reservation reservation = reservationRespository.findById(reservationId);
        if (reservation == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }
        reservation.cancel();
        System.out.println("Reserva cancelada com sucesso.");
    }

    public ReservationServiceImpl() {
    }

    @Override
    public double calculateEstimatedCost() {

        System.out.println("===== Cálculo de Custo Estimado =====");
        System.out.print("Número de dias de aluguel: ");
        int rentalDays = Integer.parseInt(System.console().readLine());
        System.out.println("Selecione o Veículo para a reserva:");
        String model = System.console().readLine();
        Vehicle calculatedVehicle = vehicleRepository.findByModel(model);
        System.out.println("Calculando custo estimado...");
        assert calculatedVehicle != null;
        Double dailyRate = calculatedVehicle.getDailyRate();

        return dailyRate * rentalDays;
    }

}
