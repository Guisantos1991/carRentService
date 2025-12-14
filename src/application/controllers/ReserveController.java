package application.controllers;

import services.ReservationServiceImpl;
import java.util.Scanner;

public class ReserveController {

    Scanner sc = new Scanner(System.in);
    public static ReservationServiceImpl reservationService;
    private CliMenuController cliMenuController;

    public ReserveController () {
        reservationService = new ReservationServiceImpl();
        this.cliMenuController = new CliMenuController();
    }
    public void start() {

        int option;
        do {
            displayMenu();
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> reservationService.createReservation();
                case 2 -> manageReservations();
                case 3 -> cliMenuController.showMainMenu();
                case 0 -> System.out.println("Saindo do sistema de reservas...");
                default -> System.out.println("Opção inválida!");
            }
        } while (option != 0);
    }

    private void displayMenu() {
        System.out.println("\n=== MENU DE RESERVAS ===");
        System.out.println("1 - Criar Reserva");
        System.out.println("2 - Gerenciar Reservas");
        System.out.println("3 - Voltar ao Menu Principal");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void manageReservations() {
        System.out.println("==== Gerenciar Reservas ====");
        System.out.println("1. Confirmar Reserva");
        System.out.println("2. Cancelar Reserva");
        System.out.println("3. Voltar ao Menu Anterior");
        System.out.print("Selecione uma opção: ");

        int option = Integer.parseInt(System.console().readLine());
        switch (option) {
            case 1:
                System.out.print("Digite o ID da reserva para confirmar: ");
                long confirmId = Long.parseLong(System.console().readLine());
                reservationService.confirmReservation(confirmId);
                break;
            case 2:
                System.out.print("Digite o ID da reserva para cancelar: ");
                long cancelId = Long.parseLong(System.console().readLine());
                reservationService.cancelReservation(cancelId);
                break;
            case 3:
                // Voltar ao menu anterior
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
