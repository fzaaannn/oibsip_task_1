import java.util.ArrayList;
import java.util.List;

public class ATM {
    private double balance;
    private List<ATMTransaction> transactions;
    private AtmUser user;

    public ATM(AtmUser user) {
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public List<ATMTransaction> getTransactions() {
        return transactions;
    }

    public boolean authenticate(String id, String pin) {
        return user.getId().equals(id) && user.getPin().equals(pin);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new ATMTransaction("Withdraw", amount));
            System.out.println("$" + amount + " has been withdrawn from your account.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new ATMTransaction("Deposit", amount));
        System.out.println("$" + amount + " has been deposited to your account.");
    }

    public void transfer(ATM targetATM, double amount) {
        if (balance >= amount) {
            balance -= amount;
            targetATM.deposit(amount);
            transactions.add(new ATMTransaction("Transfer", amount));
            System.out.println("$" + amount + " has been transferred to " + targetATM.getUser().getId() + ".");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void printTransactions() {
        for (ATMTransaction transaction : transactions) {
            System.out.println(transaction.getType() + " - " + transaction.getAmount() + " - " + transaction.getDateTime());
        }
    }

    public AtmUser getUser() {
        return user;
    }
}
