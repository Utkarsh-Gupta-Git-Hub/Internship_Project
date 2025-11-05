import java.util.Date;
import java.util.List;

public class Deposit {
    private int depositeAmount;
    private Account account;
    private String type = "Deposit";
    private String status = "Done";
    private TransactionsHistory transactionsHistory;

    public Deposit(int depositeAmount, Account account, TransactionsHistory transactionsHistory) {
        this.depositeAmount = depositeAmount;
        this.account = account;
        this.transactionsHistory = transactionsHistory;
    }
    void add(int amt){
        int n = amt+account.getAmount();
        account.setAmount(n);
        Transaction transaction = new Transaction(type,amt,status,new Date().toString());
        List<Transaction> transactionList = transactionsHistory.getTransactions();
        transactionList.add(transaction);
        transactionsHistory.setTransactions(transactionList);
        System.out.println("Deposit successful! ₹" + amt + " added.");
        System.out.println("Updated balance: ₹" + account.getAmount());

    }

}
