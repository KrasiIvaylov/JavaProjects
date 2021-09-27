package BankAccount;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }


    public double getBalance() {
        return this.balance;
    }


    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;

    }
}
