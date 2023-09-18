import java.util.*;

public class Program4 {
    public void run() {
        Scanner iScanner = new Scanner(System.in);
        IBag<String> bag;
        System.out.print("Which type of bag do you want? ");
        String input = iScanner.nextLine();
        if (input.toLowerCase().equals("sorted")) {
            bag = new SortedBag<String>();// if user chooses sorted
        } else {
            bag = new UnsortedBag<String>();// otherwise default is unsorted
        }
        System.out.print("How many items to put in the bag?");
        int size = iScanner.nextInt();// criteria for size of bag
        iScanner.nextLine();
        for (int i = 1; i <= size; i++) {// loops given on the user input
            System.out.print("Enter item " + i + ": ");
            String item = iScanner.nextLine();
            bag.add(item);
        }
        String guess = "";
        System.out.println("You can check if something is in the bag.");
        while (!guess.toLowerCase().equals("done")) {// loops until user types done
            System.out.print("Check for (type done to stop): ");
            guess = iScanner.nextLine();
            if (bag.contains(guess)) {
                System.out.println("Yes, it is in the bag.");// message if bag returns true
            } else {
                System.out.println("No, it's not in the bag.");// message if bag returns false
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println("Removing item: " + bag.remove(0).toString());// removes all items in bag and prints to
                                                                             // user
        }
        iScanner.close();
    }

    public static void main(String[] args) {
        Program4 instance = new Program4();
        instance.run();
    }

}
