# ATM Application

## 1. Compilation and Execution

When compiling or running the program, add JavaFX libraries to the classpath.

### Running the Application

To run the ATM application:

1. Clone or download this repository to your local machine.
2. Open a terminal or command prompt and navigate to the directory where the project is located.
3. Compile and run the program using the following commands:

#### Compilation (If using a terminal):

```bash
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml ATMApplication.java
```

#### Running the application:

```bash
java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml ATMApplication
```

---

## 2. Application Overview

### 1. Main Screen:
Displays basic ATM options such as:
- Check Balance
- Deposit
- Withdraw

### 2. Withdraw Screen:
- User is prompted to enter the withdrawal amount.
- If the amount is available in the balance, the transaction proceeds.
- If not, an error message is displayed.

### 3. Deposit Screen:
- User enters the amount to deposit into their account.
- The balance is updated accordingly.

### 4. Balance Screen:
- Displays the current balance of the user’s account.

---

## 3. Example UI Flow

1. **Start Application** → Displays ATM menu  
2. **User selects Withdraw** → Enter amount → Confirmation or error based on balance  
3. **User selects Deposit** → Enter deposit amount → Confirmation  
4. **User selects Check Balance** → Displays current balance  

---

## 4. Screenshots

- **Main menu** where the user selects actions like Withdraw, Deposit, or Check Balance.  
- **Withdraw screen** where the user enters the withdrawal amount.  
- **Deposit screen** where the user enters the deposit amount.  

---

## 5. How to Use

1. Launch the application by running the `ATMApplication.java` class.
2. Upon startup, the user will be presented with a main menu with the following options:
   - Withdraw
   - Deposit
   - Check Balance
3. Select the action you want to perform by clicking the respective button.
4. Follow the on-screen instructions for each action (entering withdrawal/deposit amounts or simply viewing the balance).
5. After completing the transaction, the application will return to the main menu for further actions or exit.

---

## 6. Code Structure

- **`ATMApplication.java`**: Main class to launch the JavaFX application.  
- **`ATMController.java`**: Controller class to handle the logic for each ATM operation (withdraw, deposit, balance check).  
- **`BankAccount.java`**: Model class representing a user's bank account with methods for deposit, withdrawal, and balance check.  
- **FXML Files**: The UI layout for the main menu, withdraw, deposit, and balance screens.  

---

## 7. Known Issues

- No authentication mechanism is implemented, so anyone can access the ATM functions without logging in.
- This application is designed for educational purposes and is not connected to any real banking system.

---


## 8. Credits

- **JavaFX** for building the GUI  
- **Java 11+** for the core application logic  

---

## 9. Contact

For questions or suggestions, feel free to reach out to the developer at yingisanihonest694@gmail.com
