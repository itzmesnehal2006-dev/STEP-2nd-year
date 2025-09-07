import java.util.Random;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    // 1. Default constructor → balance = 0
    BankAccount() {
        this("Unknown", 0.0);
    }

    // 2. Constructor with name → assigns random account number
    BankAccount(String accountHolder) {
        this(accountHolder, 0.0);
    }

    // 3. Constructor with name + initial balance
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = generateAccountNumber();
        this.balance = balance;
    }

    // Helper: Generate random account number
    private int generateAccountNumber() {
        Random rand = new Random();
        return 10000 + rand.nextInt(90000); // 5-digit number
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolder + " deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Display account details
    void displayAccount() {
        System.out.println("🏦 Bank Account Details");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating accounts using different constructors
        BankAccount acc1 = new BankAccount();                 // Default
        BankAccount acc2 = new BankAccount("Snehal");         // Name only
        BankAccount acc3 = new BankAccount("Arjun", 5000.0);  // Name + Balance

        // Transactions
        acc2.deposit(2000);
        acc2.withdraw(500);
        acc3.withdraw(1000);
        acc3.deposit(1500);

        // Display accounts
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();
    }
}
