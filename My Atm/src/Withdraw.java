import javax.xml.transform.Source;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Withdraw {
    private int withdrawAmount;
    private String type = "Withdraw";
    private String status = "Done";
    private Account account;
    private TransactionsHistory transactionsHistory;
    public Withdraw( int withdrawAmount,Account account,TransactionsHistory transactionsHistory){
        this.transactionsHistory=transactionsHistory;
        this.withdrawAmount=withdrawAmount;
       this.account=account;
    }
    void cut(int withdrawAmount){
        if(withdrawAmount>this.account.getAmount()||account.getAmount()==0){
            System.out.println("Insufficient Balanace");
        }else {
           int amnt = account.getAmount()-withdrawAmount;
            account.setAmount(amnt);
            Transaction transaction = new Transaction(type,account.getAmount(),status,new Date().toString());
            List<Transaction> transactionList= transactionsHistory.getTransactions();
            transactionList.add(transaction);
            transactionsHistory.setTransactions(transactionList);
            System.out.println("Withdrawal successful! ₹" + withdrawAmount + " withdrawn.");
            System.out.println("Remaining balance: ₹" + account.getAmount());
        }
    }

}
