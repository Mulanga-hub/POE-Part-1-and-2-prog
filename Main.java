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
                    String hash = msg.createMessageHash();

                    System.out.println("Message Hash: " + hash);

                    System.out.println("\nChoose an action:");
                    System.out.println("1. Send Message");
                    System.out.println("2. Discard Message");
                    System.out.println("3. Store Message");

                    int action = input.nextInt();
                    input.nextLine();

                    switch (action) {

                        case 1:
                            System.out.println("Message successfully sent.");
                            messages.add("SENT | ID: " + id + " | HASH: " + hash + " | RECIPIENT: " + recipient);
                            break;

                        case 2:
                            System.out.println("Message discarded.");
                            break;

                        case 3:
                            System.out.println("Message stored successfully.");
                            messages.add("STORED | ID: " + id + " | HASH: " + hash + " | RECIPIENT: " + recipient);
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }

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