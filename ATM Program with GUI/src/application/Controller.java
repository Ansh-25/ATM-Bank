package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

public class Controller{
	
	public Controller() {
		if(k==0) {
			atm.loadDatabase();
			atm.updateDatabase();
			k++;
		}
	}
	
	@FXML
    public void initialize() {
		if(balance!=null) balance.setText(user.account.getBalance() + " RS");
    }
	
	static int k = 0;
	
	@FXML
	private Button button;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Text errorMessage;
	
	@FXML
	private TextField deposit;
	
	@FXML
	private TextField withdraw;
	
	@FXML
	private Label message;
	
	@FXML
	private Text balance;
	
	static int paisa;
	
	String pin;
	
	private Main win = new Main();
	static User user = new User();
	static ATM atm = new ATM();
	
	public void userLogin(ActionEvent event) throws IOException {
		pin = password.getText().toString();
        if(atm.start(pin)==1) {
        	user = atm.getUser(pin);
        	win.changeScene("selectTransaction.fxml");
        }
        else errorMessage.setText("Incorrect Pin");
	}
	
	public void withdrawWindow(ActionEvent event) throws IOException {
		win.changeScene("withdrawWindow.fxml");
	}
	
	public void depositWindow(ActionEvent event) throws IOException {
		win.changeScene("depositWindow.fxml");
	}
	
	public void checkBalanceWindow(ActionEvent event) throws IOException {
		paisa = user.account.getBalance();
		win.changeScene("checkBalanceWindow.fxml");
	}
	
	public void withdraw(ActionEvent event) throws IOException {
		if(atm.withdraw(Integer.parseInt(withdraw.getText().toString()), user) == 1) {
			paisa = user.account.getBalance();
			win.changeScene("success.fxml");
		}
		else 
			win.changeScene("fail.fxml");
	}
	
	public void deposit(ActionEvent event) throws IOException {
		user.account.updateBalance(Integer.parseInt(deposit.getText().toString()));
		paisa = user.account.getBalance();
		win.changeScene("success.fxml");
	}
	
	
	public void signout(ActionEvent event) throws IOException {
		user.account.setBalance(paisa);
		atm.updateUser(user);
		atm.updateDatabase();
		win.changeScene("welcome.fxml");
	}
	
}
