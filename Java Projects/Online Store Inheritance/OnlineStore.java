import java.util.Scanner;

public class OnlineStore {// store class
    private ItemInventory inventory;// inventory variable

    public void start() {// starts the store
        inventory = new ItemInventory();// creates a new inventory every time store is open
        inventory.load("sampleData.txt");// loads the given sample data since we only need to read
        boolean exit = false;// used to stop the program;
        int choice;// used in the switch;
        Scanner input = new Scanner(System.in);// reads user input
        while (exit == false) {
            System.out.println(// prints out menu options to user
                    "Welcome to eMart\n    1) Show all items\n    2) Show only music CD\n    3) Show only books\n    4) Show only software\n    5)Exit program");
            choice = input.nextInt();// takes in user input
            input.nextLine();
            switch (choice) {
                case 1:// shows entire inventory
                    inventory.print("all");
                    break;
                case 2:// shows only music items
                    inventory.print("Music");
                    break;
                case 3:// shows only book items
                    inventory.print("Book");
                    break;
                case 4:// showo nly software items
                    inventory.print("Software");
                    break;
                case 5:// exits program
                    exit = true;
                    break;
                default:// in case user enters an outside value
                    System.out.println("Please enter a valid option!");
            }
        }
        System.out.println("Thank you for shopping with us! Please come again!");// exit message
        input.close();// closes scanner
    }
}