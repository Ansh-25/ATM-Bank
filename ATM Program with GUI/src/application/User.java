package application;

public class User {
    String name;
    int id;
    Account account;
    Card card;

    User(String name,int id,int balance,String pin){
        this.name = name;
        this.id = id;
        this.account = new Account(balance);
        this.card = new Card(pin);
    }
    
    User(){}
}
