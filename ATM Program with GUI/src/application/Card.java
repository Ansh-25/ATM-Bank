package application;

public class Card {
    private String pin ;

    boolean authenticate(String pin){
        if(this.pin.equals(pin)) return true;
        return false;
    }

    Card(String pin){
        this.pin = pin;
    }

    String getPin() {
        return pin;
    }
}