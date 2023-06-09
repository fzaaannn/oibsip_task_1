import java.time.LocalDateTime;

public class ATMTransaction {
    private String type;
    private double amount;
    private LocalDateTime dateTime;

    public ATMTransaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
