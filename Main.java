import java.util.Scanner;

public class Main {

    static int messageCounter = 0;
    static java.util.ArrayList<String> messages = new java.util.ArrayList<>();

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

                    System.out.println("Enter recipient number:");
                    String recipient = input.nextLine();

                    System.out.println("Enter message (max 250 chars):");
                    String text = input.nextLine();

                    messageCounter++;
                    int messageNumber = messageCounter;

                    Message msg = new Message("", recipient, text, messageNumber);

                    if (!msg.checkMessageLength()) {
                        System.out.println("Message exceeds 250 characters");
                        break;
                    }

                    if (!msg.checkRecipientCell()) {
                        System.out.println("Invalid recipient number format");
                        break;
                    }

                    String id = msg.generateMessageID();

                    System.out.println("Message sent successfully");
                    System.out.println("Message ID: " + id);
                    System.out.println("Message Hash: " + msg.createMessageHash());

                    messages.add("ID: " + id + " | HASH: " + msg.createMessageHash() + " | RECIPIENT: " + recipient);

                    break;

                case 2:

                    if (messages.isEmpty()) {
                        System.out.println("No messages sent yet.");
                    } else {
                        System.out.println("Recently sent messages:");
                        for (String m : messages) {
                            System.out.println(m);
                        }
                    }

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