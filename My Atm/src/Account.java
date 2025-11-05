import java.util.Random;

public class Account {
    private int amount;
    private int id;

    public Account(int amount) {
        this.amount = amount;
        this.id=new Random().nextInt();
    }

    public  int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String
    toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }
}
