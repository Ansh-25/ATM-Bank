

public class App {

	public static void main(String[] args) {
        ATM atm = new ATM();
        atm.loadDatabase();
        atm.start();
        atm.updateDatabase();
        return;
	}
}
