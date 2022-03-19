import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        //initialise Scanner
        Scanner sc = new Scanner(System.in);

        //initialise bank
        Bank theBank = new Bank("Bank of Bulgaria");

        //add a user to the bank
        User aUser = theBank.addUser("John", "Doe", "1234");

        //add a checking account for our user
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        do {

            //stay in the login prompt until successful login
            curUser = ATM.mainMenuPrompt(theBank, sc);

            //stay in main menu until user quits
            ATM.printUserMenu(curUser, sc);

        } while (true);
    }

    public static User mainMenuPrompt(Bank theBank, Scanner sc) {
        String userID;
        String pin;
        User authUser;

        //prompt user for user ID/pin combo untill correct
        do {
            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.println("Enter User ID: ");
            userID = sc.nextLine();
            System.out.println("Enter pin: ");
            pin = sc.nextLine();

            //try get user object for responding to ID & pin combo
            authUser = theBank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Incorrect user ID/pin combination. " +
                        "Please try again.");
            }
        } while (authUser == null);// continue looping until success
        return authUser;

    }

    public static void printUserMenu(User theUser, Scanner sc) {

        //print a summary of the users accounts
        theUser.printAccountsSummary();

        //initialise
        int choise;

        //user menu
        do {
            System.out.printf("Welcome %s, what would you like to do?\n", theUser.getFirstName());
            System.out.println(" 1) Show account transaction history");
            System.out.println(" 2) Withdraw");
            System.out.println(" 3) Deposit");
            System.out.println(" 4) Transfer");
            System.out.println(" 5) Quit");
            System.out.println();
            System.out.println("Enter choice: ");
            choise = sc.nextInt();

            if (choise < 1 || choise > 5) {
                System.out.println("Invalid operation");
            }
        } while (choise < 1 || choise > 5);

        //process the choice
        switch (choise) {
            case 1:
                ATM.showTransactionHistory(theUser, sc);
                break;
            case 2:
                ATM.withdrawFunds(theUser, sc);
                break;
            case 3:
                ATM.depositFunds(theUser, sc);
                break;
            case 4:
                ATM.transferFunds(theUser, sc);
                break;
            case 5:
                // gobble up rest of previous input
                sc.nextLine();
                break;
        }

        //redisplay this menu unless the user wats to quit
        if (choise != 5) {
            ATM.printUserMenu(theUser, sc);
        }
    }

    /**
     * Shows the transaction history for an account
     *
     * @param theUser the logged - in User object
     * @param sc      the Scanner object used for user input
     */
    public static void showTransactionHistory(User theUser, Scanner sc) {

        int theAcct;
        //get account whose transaction history to look at
        do {

            System.out.printf("Enter the number (1-%d) of the account\n " +
                            "whose transactions you want to see : ",
                    theUser.numAccounts());
            theAcct = sc.nextInt() - 1;
            if (theAcct < 0 || theAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account, please try again!");
            }
        } while (theAcct < 0 || theAcct >= theUser.numAccounts());

        //print the transaction history
        theUser.printAccountTransactionHistory(theAcct);
    }

    public static void transferFunds(User theUser, Scanner sc) {
        //initialization
        int fromAcct;
        int toAcct;
        double amount;
        double acctBalance;

        //get account to transfer from
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to transfer from: ", theUser.numAccounts());
            fromAcct = sc.nextInt() - 1;
            if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account, please try again!");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccounts());

        acctBalance = theUser.getAcctBallance(fromAcct);

        //get the account to transfer to
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to transfer to: ", theUser.numAccounts());
            toAcct = sc.nextInt() - 1;
            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account, please try again!");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccounts());

        //get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $",
                    acctBalance);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero.");
            } else if (amount > acctBalance) {
                System.out.printf("Amount must not be greater than\n" +
                        "balance of $%.02f.\n", acctBalance);
            }
        } while (amount < 0 || amount > acctBalance);

        //finaly do the transfer
        theUser.addAccountTransaction(fromAcct, -1 * amount, String.format(
                "Transfer to account %s", theUser.getAcctUUID(toAcct)));
        theUser.addAccountTransaction(toAcct, amount, String.format(
                "Transfer to account %s", theUser.getAcctUUID(fromAcct)));

    }

    /**
     * Process a fund withdraw from an account
     *
     * @param theUser the logged in object
     * @param sc      the Scanner object user for user input
     */
    public static void withdrawFunds(User theUser, Scanner sc) {
        //initialization
        int fromAcct;
        double amount;
        double acctBalance;
        String memo;

        //get account to transfer from
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to withdraw from: ", theUser.numAccounts());
            fromAcct = sc.nextInt() - 1;
            if (fromAcct < 0 || fromAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account, please try again!");
            }
        } while (fromAcct < 0 || fromAcct >= theUser.numAccounts());

        acctBalance = theUser.getAcctBallance(fromAcct);

        do {
            System.out.printf("Enter the amount to withdraw (max $%.02f): $",
                    acctBalance);
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be greater than zero.");
            } else if (amount > acctBalance) {
                System.out.printf("Amount must not be greater than\n" +
                        "balance of $%.02f.\n", acctBalance);
            }
        } while (amount < 0 || amount > acctBalance);
        // gobble up rest of previous input
        sc.nextLine();

        //get a memo
        System.out.println("Enter a memo: ");
        memo = sc.nextLine();

        //do the withdraw
        theUser.addAccountTransaction(fromAcct, -1 * amount, memo);
    }

    /**
     * Process a fund deposit to an account
     *
     * @param theUser the logged-in User object
     * @param sc      the Scanner object used for user input
     */
    public static void depositFunds(User theUser, Scanner sc) {

        //initialization
        int toAcct;
        double amount;
        double acctBalance;
        String memo;

        //get account to transfer from
        do {
            System.out.printf("Enter the number (1-%d) of the account\n" +
                    "to deposit in: ", theUser.numAccounts());
            toAcct = sc.nextInt() - 1;
            if (toAcct < 0 || toAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account, please try again!");
            }
        } while (toAcct < 0 || toAcct >= theUser.numAccounts());

        acctBalance = theUser.getAcctBallance(toAcct);

        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $", acctBalance);
            amount = sc.nextDouble();

            if (0 > amount) {
                System.out.println("Amount must be greater than zero.");
            }
        } while (amount < 0);
        // gobble up rest of previous input
        sc.nextLine();

        //get a memo
        System.out.println("Enter a memo: ");
        memo = sc.nextLine();

        //do the withdraw
        theUser.addAccountTransaction(toAcct, amount, memo);

    }
}
