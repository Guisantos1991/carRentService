package application;

import application.controllers.CliMenuController;


import java.util.Locale;
import java.util.Scanner;

public class CarRentalApplication {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        CliMenuController cliMenuController = new CliMenuController();
        cliMenuController.showMainMenu();

    }
}
