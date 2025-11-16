package application;

import application.usecases.CreateClient;
import infrastructure.MemoryClientRepository;


import java.util.Locale;
import java.util.Scanner;

public class CarrentalApplication {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        MemoryClientRepository memoryClientRepository = new MemoryClientRepository();
        CreateClient createClient = new CreateClient(memoryClientRepository);

        System.out.println("Please enter data:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Mobile: ");
        String mobile = sc.nextLine();
        createClient.execute(id, name, cpf, email, mobile);

        //Display test client created
        System.out.println(createClient.toString());

    }
}
