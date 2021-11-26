

public class Account {
    private int balance = 0;

    void updateBalance(int money){
        balance = balance + money;
    }

    Account(int balance){
        this.balance = balance;
    }

    int getBalance(){
        return balance;
    }

}