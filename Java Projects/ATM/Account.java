import java.util.Date;

public class Account {
    private int id = 0; // sets class variables and default values
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date();

    public Account() {
    }

    public Account(int inputID, double inputbal) { // Constructor with id, bal, and date created
        id = inputID;
        balance = inputbal;
    }

    public void setID(int inputID) { // set function for ID
        id = inputID;
    }

    public void setBalance(double inputbal) { // set function for balance
        balance = inputbal;
    }

    public void setAnnualInterestRate(double inputIR) { // set function for interest rate
        annualInterestRate = inputIR;
    }

    public int getID() { // get function for ID
        return id;
    }

    public double getBalance() { // get function for balance
        return balance;
    }

    public double getAnnualInterestRate() { // get function for interest rate
        return annualInterestRate;
    }

    public String getDate() { // get function for date
        return dateCreated.toString();
    }

    public double getMonthlyInterestRate() { // get function for monthly rate
        return annualInterestRate / 12; // divides annual rate by 12
    }

    public double withdraw(double amount) { // withdraw function
        if (balance - amount < 0) { // return same balance if withdraw amount is greater than balance
            return balance;
        } else {
            balance -= amount; // subtracts withdraw amount from balance
            return balance; // return balance
        }
    }

    public double deposit(double amount) {// deposit function
        balance += amount; // add deposit amount to balance
        return balance;// returns new balance
    }
}
