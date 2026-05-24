import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int choice;

        System.out.println("Welcome to QuickChat");

        do {

            System.out.println("\nChoose an option:");
            System.out.println("1. Send Message");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Send Message selected");
                    break;

                case 2:
                    System.out.println("Coming Soon");
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (choice != 3);

    }
}