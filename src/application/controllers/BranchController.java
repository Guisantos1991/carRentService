package application.controllers;

import application.domain.entities.Branch;
import services.BranchServicesImpl;

import java.util.Scanner;

public class BranchController {

    private final BranchServicesImpl branchServices;
    private final CliMenuController cliMenuController;
    private final Scanner scanner = new Scanner(System.in);

    public BranchController() {
        this.branchServices = new BranchServicesImpl();
        this.cliMenuController = new CliMenuController();
    }

    public void start() {
        System.out.println("===== Gestão de Pontos de Atendimento =====");
        int option = -1;

        while (option != 4) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Cadastrar Ponto de Atendimento");
            System.out.println("2. Listar Pontos de Atendimento");
            System.out.println("3. Atualizar Ponto de Atendimento");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Opção: ");

            String line = scanner.nextLine();
            try {
                option = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número entre 1 e 4.");
                continue;
            }

            switch (option) {
                case 1:
                    try {
                        System.out.println("\nCadastrar Ponto de Atendimento");
                        System.out.print("Id do Ponto: ");
                        long id = Long.parseLong(scanner.nextLine());
                        System.out.print("Nome do Ponto: ");
                        String name = scanner.nextLine();
                        System.out.print("Digite o CEP: ");
                        String code = scanner.nextLine();
                        System.out.print("Confirme o Endereço: ");
                        String address = scanner.nextLine();

                        Branch branch = new Branch(id, name, code, address);
                        branchServices.createBranch(branch);
                        System.out.println("Ponto de atendimento cadastrado com sucesso!");
                    } catch (NumberFormatException ex) {
                        System.out.println("ID inválido. Operação cancelada.");
                    }
                    break;
                case 2:
                    System.out.println("Listar pontos de atendimento");
                    branchServices.getBranches().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Atualizar ponto de atendimento");
                    System.out.print("Digite o nome do ponto de atendimento a ser atualizado: ");
                    String branchName = scanner.nextLine();
                    branchServices.updateBranch(branchName);
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal...");
                    cliMenuController.showMainMenu();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}