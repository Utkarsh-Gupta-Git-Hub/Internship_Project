import java.util.Date;
import java.util.List;

public class Transfer {

    private String type = "Transfer";
    private String status = "Done";
    private TransactionsHistory transactionsHistory;
    private int amt;

    public Transfer( TransactionsHistory transactionsHistory) {
        this.transactionsHistory = transactionsHistory;
    }
    void transfer(int amt ,Account accountFrom, Account accountTo){
        if(accountFrom.getAmount()<amt){
            System.out.println("Insufficient Balance.");
            status="Failed";
        }else{
         int newamt = accountFrom.getAmount()-amt;
         accountTo.setAmount(accountTo.getAmount()+amt);
         accountFrom.setAmount(newamt);
            System.out.println("Transfer successful! ₹" + amt + " transferred.");
            System.out.println("Sender Account: "+accountFrom);
            System.out.println("Sender new balance: ₹" + accountFrom.getAmount());
            System.out.println("Reciever Accounr: "+accountTo);
            System.out.println("Receiver new balance: ₹" + accountTo.getAmount());

        }
        Transaction transaction = new Transaction(type,amt,status,new Date().toString());
        List<Transaction> transactionList= transactionsHistory.getTransactions();
        transactionList.add(transaction);
        transactionsHistory.setTransactions(transactionList);
    }
}
