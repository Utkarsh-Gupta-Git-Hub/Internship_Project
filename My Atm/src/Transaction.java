public class Transaction {
    private String type;        // Deposit, Withdraw, Transfer
    private int amount;
    private String details;     // Optional info like "To user 102"
    private String dateTime;    // Timestamp

    public Transaction(String type, int amount, String details, String dateTime) {
        this.type = type;
        this.amount = amount;
        this.details = details;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", details='" + details + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
