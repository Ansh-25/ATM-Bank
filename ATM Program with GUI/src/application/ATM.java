package application;

import java.io.File;
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
    
    void updateUser(User newUser) {
    	for(User user : users){
            if(user.id == newUser.id){
                user.account.setBalance(newUser.account.getBalance());
            }
            else continue;
        }
    }

    int start(String pin){

        for(User user : users){
            if(user.card.authenticate(pin)){
                return 1;
            }
            else continue;
        }
        return 0;
    }
    
    User getUser(String pin) {
    	for(User user : users){
            if(user.card.authenticate(pin)){
                return user;
            }
            else continue;
        }
    	return null;
    }

    void deposit(int deposit , User user){
        user.account.updateBalance(deposit);
    }

    int withdraw(int money , User user){
        if(money<=user.account.getBalance()){
            user.account.updateBalance(-money);
            return 1;
        }
        return 0;
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
                file.renameTo(new File("Database.csv"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}