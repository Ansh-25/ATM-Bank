# Getting Started  
You can start running the application using password 1234 or 5555 or 2512 . Refer the Database.csv for more info about current Users.
## Overview
This ATM application contains 5 main classes :
1. **ATM**  
Contains main logic of transactions , database usage and interface. Contains a list of users of the Bank which it loads from the database and updates into the database.
2. **User**  
Every instance of a User has a name , id , card and an account. It also contains a constructor to initialize that instance.
3. **Account**  
Contains the balance associated with the user’s account . It has its own getter setter and a constructor.
4. **Card**  
Contains a variable named pin with its getter. It also contains an authentication function for the password returning a Boolean value.
5. **App**  
App class contains the main driver function . It makes an instance of ATM class and loads the database. It calls the start function from ATM and at the end updates the database.
### GUI Specific
1. **Main**  
It is the driver function for the GUI application. It sets the stage dimensions and title and contains a change scene function.
2. **Controller**  
Holds the main logic of the GUI . All .fxml files are connected to the controller . All buttons on the GUI scenes are linked to functions of the controller . Ex: signout function runs when sign out button is pressed in the window. It uses private fields with decorator @FXML to access Text fields or labels using their id. Constructor of the controller load and updates the database at the time of start of the application. It works with other 5 main classes In the backend to display success or failure messages on the GUI. It uses an instance of Main to change scene from its functions.
## Future improvements possible
1. Connect a SQL database with the application.
2. Store the password after hashing them for security.
3. Improve class design and implement multithreading .
4. Use name and security question for authentication before heavy transaction.
5. Improve/enhance GUI’s frontend UI/UX.
## Additional requirements
1. Javafx (for GUI application) .
## UML Diagrams
[UML Diagrams.pdf](https://github.com/Ansh-25/ATM-Bank/files/7609928/UML.Diagrams.pdf)
## Video walkthrough


https://user-images.githubusercontent.com/75000839/143612374-e56c883a-2741-4043-a34f-79fe0c4f8a33.mp4



https://user-images.githubusercontent.com/75000839/143612386-88fd86a6-d6d7-4b19-b3b6-9c9f52a6f31d.mp4



