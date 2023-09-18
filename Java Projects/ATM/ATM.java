//This project was created by Kevin Nguyen for CSC322 and is done using his own code.

import java.util.Scanner;
import java.util.Random;

public class ATM {
    public static void balance(Account input) {// balance function
        System.out.print("\nThe current balance is: $" + input.getBalance()); // prints the balance to the user
    }

    public static void withdraw(Account input, Scanner userInput) { // withdraw function
        System.out.print("\nPlease enter the amount to withdraw: ");
        double amount = userInput.nextDouble(); // sets withdraw value to user input
        System.out.print("\nYour new balance is: " + input.withdraw(amount)); // withdraws from account and returns
                                                                              // balance
    }

    public static void deposit(Account input, Scanner userInput) { // deposit function
        System.out.print("\nPlease enter the amount to deposit: ");
        double amount = userInput.nextDouble(); // sets depsoit value to user input
        System.out.print("\nYour new balance is: " + input.deposit(amount));// depsoits amount and returns new balance
    }

    public static void accountinfo(Account input) {// account info function
        System.out.print("\nAccount was created on: " + input.getDate() + "\nAccount interest rate is: "
                + input.getAnnualInterestRate() + "\nAccount Balance is: " + input.getBalance());// prints all the
                                                                                                 // account info
    }

    public static void main(String args[]) {// main function
        Account[] accountArray = new Account[10];// creates an array of 10 account objects
        for (int i = 0; i < 10; i++) {
            accountArray[i] = new Account(i, 100); // inserts 10 accounts with 100 dollars
        }
        while (true) {// main loop with no breaks
            Scanner input = new Scanner(System.in);// scanner for user input
            boolean menuLoop = true;// sets the account menu loop
            Account currAcct;// used in the menu loop
            System.out.print("Enter the account id: ");// asks for user for account id
            int id = input.nextInt();// id is stored
            input.nextLine();
            while (id < 0 || id > 9) {// loops until valid account is inserted
                System.out.print("\nPlease insert an existing account.");
                id = input.nextInt();
                input.nextLine();
            }
            currAcct = accountArray[id];
            while (menuLoop == true) {
                System.out.print(// account menu options
                        "\nMain Menu\n1. Check Balance\n2. Withdraw\n3. Deposit\n4. Account Information\n5. Exit(choose different account)\nPlease make a selection: ");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        balance(currAcct);// shows balance
                        break;
                    case 2:
                        withdraw(currAcct, input);// withdraws inputted amount
                        break;
                    case 3:
                        deposit(currAcct, input);// deposits inputted amount
                        break;
                    case 4:
                        accountinfo(currAcct);// prints account info
                        break;
                    case 5:
                        menuLoop = false; // changes menu loop to change account
                        break;
                    default:
                        System.out.print("\nPlease select a valid input!");// in case if input is none of the listed
                                                                           // choices
                }

            }
        }
    }
}