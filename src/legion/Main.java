package legion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        if (login.equals("Admin") && password.equals("2236")) {
            DomParser domParser = new DomParser();
            domParser.menu();
        } else {
            System.out.println("Неверный логин или пароль!");
        }
    }
}
