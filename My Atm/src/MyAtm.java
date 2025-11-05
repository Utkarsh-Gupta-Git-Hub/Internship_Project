
import java.io.IOException;

import java.util.Scanner;

public class MyAtm {
    private  Account account;
    private  TransactionsHistory transactionsHistory;
    public MyAtm() {
       this.account= new Account(5000);
       this.transactionsHistory=new TransactionsHistory();
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        MyAtm atm = new MyAtm();
        int press=0;
        System.out.println("Hi, What do you want to do");
        while(press!=5){
            System.out.println("Press 1 : Transactions History");
            System.out.println("Press 2 : Withdraw");
            System.out.println("Press 3 : Deposit");
            System.out.println("Press 4 : Transfer");
            System.out.println("Press 5 : Quit");
            System.out.print("Enter your no : ");
            press = sc.nextInt();
            switch (press){
                case 1->{
                    System.out.println("         Transaction History        ");
                    System.out.println(atm.transactionsHistory.getTransactions());
                }
                case 2->{
                        System.out.print("Enter your withdraw amount : ");
                        int withdrawAmount=sc.nextInt();
                        Withdraw withdraw = new Withdraw(withdrawAmount,atm.account,atm.transactionsHistory);
                        withdraw.cut(withdrawAmount);
                }
                case 3->{
                    System.out.print("Enter the deposit amount: ");
                    int depositeAmount= sc.nextInt();
                    Deposit deposit = new Deposit(depositeAmount,atm.account,atm.transactionsHistory);
                    deposit.add(depositeAmount);
                }
                case 4->{
                    System.out.print("Enter your transfer amount: ");
                    int transferAmt = sc.nextInt();

                    // Create a second account for testing (receiver)
                    Account receiver = new Account(2000);
                    Transfer transfer = new Transfer( atm.transactionsHistory);
                    transfer.transfer(transferAmt, atm.account, receiver);
                }
                case 5 -> System.out.println("Thank you for choosing us");

            }
        }
    }
}
