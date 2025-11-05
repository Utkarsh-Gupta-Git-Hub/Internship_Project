import java.util.ArrayList;
import java.util.List;

public class TransactionsHistory {
    private  List<Transaction> transactions;

    public TransactionsHistory(){
        this.transactions= new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
