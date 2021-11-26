import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM{
    ArrayList<User> users;

    ATM(){
        this.users = new ArrayList<User>();
    }

    void addUser(User user){
        this.users.add(user);
    }

    void start(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your pin");
        String pin = sc.nextLine();

        for(User user : users){
            if(user.card.authenticate(pin)){
                selectTransaction(user , sc);
                cont();
                sc.close();
                return;
            }
            else continue;
        }
        System.out.println("Incorrect Password");
        cont();
        sc.close();
        return;
    }

    void selectTransaction(User user , Scanner sc){
        System.out.println("Select Transaction");
        System.out.println("Enter 1: Cash Withdraw");
        System.out.println("Enter 2: Cash Deposit");
        System.out.println("Enter 3: View Balance");
        int choice = sc.nextInt();
        switch(choice){
            case 1: 
                System.out.println("Enter amount to be withdrawn:");
                int money = sc.nextInt();
                withdraw(money,user);
                break;
            case 2:
                System.out.println("Enter amount to be Deposited:");
                int amt = sc.nextInt();
                deposit(amt,user);
                break;
            case 3:
                System.out.println("The balance is " + user.account.getBalance());
                break;
        }
        return;
    }

    void deposit(int deposit , User user){
        user.account.updateBalance(deposit);
        exit();
        return;
    }

    void withdraw(int money , User user){
        if(money<=user.account.getBalance()){
            user.account.updateBalance(-money);
            exit();
        }
        else error("Insuffient funds");
        return;
    }

    void exit(){
        System.out.println("Transaction was successful");
    }

    void error(String msg){
        System.out.printf("ERROR: Transaction Failed - %s \n",msg);
    }
    
    void loadDatabase(){
        File file = new File("Database.csv");

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String tokens[] = s.split(",");
                User user = new User(tokens[0],Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),tokens[3]);
                addUser(user);
            }
            sc.close();
            file.delete();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateDatabase(){

        File file = new File("temp.csv");
        try {
            if(file.createNewFile()){
                try{
                    PrintWriter pw = new PrintWriter(file);

                    for(User user: users){
                        pw.printf("%s,%s,%d,%s%n",user.name,user.id,user.account.getBalance(),user.card.getPin());
                    }

                    pw.close();

                    file.renameTo(new File("Database.csv"));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Failed to create temp file");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void cont(){
        System.out.println("Do you want to continue?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            if(s.charAt(0)=='y'){
                start();
                br.close();
            }
            else return;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}