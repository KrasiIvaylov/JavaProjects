import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    //First name of the user
    private String firstName;

    //Last name of the user
    private String lastName;

    //ID of the user
    private String uuid;

    //The MD5 of the user's pin number
    private byte pinHash[];

    //The list of accounts for this user
    private ArrayList<Account> accounts;

    /**
     * *Create a new user
     *
     * @param firstname The users first name
     * @param lastName  The users last name
     * @param pin       The users account pin number
     * @param theBank   The ank object that the user is a customer of
     */

    // Set user's name
    public User(String firstname, String lastName, String pin, Bank theBank) {
        this.firstName = firstname;
        this.lastName = lastName;

        // Store the pin's MD5 hash, rather then the original value
        // for security reasons

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        //get a new, unique universal ID for the use
        this.uuid = theBank.getNewUserUUID();

        //create empty list of accounts
        this.accounts = new ArrayList<Account>();

        //Print log message
        System.out.printf("New user %s, %s with ID %s created. \n", lastName, firstname, uuid);
    }

    /**
     * Add an account of the user
     *
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    /**
     * Return the use's UUID
     *
     * @return the uuid
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Check wheather a given pin matches the true User pin
     *
     * @param aPin the pin to check
     * @return whether the pin is valid or not
     */
    public boolean validatePin(String aPin) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),
                    this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }

    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Print summaries for the accounts of the user.
     */
    public void printAccountsSummary() {

        System.out.printf("\n\n%s's accounts summary\n", this.firstName);
        for (int a = 0; a < this.accounts.size(); a++) {
            System.out.printf(" %d) %s \n", a + 1
                    , this.accounts.get(a).getSummaryLine());
        }
        System.out.println();

    }

    public int numAccounts() {
        return this.accounts.size();
    }

    /**
     * Print transaction history for particular account
     *
     * @param acctIdx the indec of the account to use
     */
    public void printAccountTransactionHistory(int acctIdx) {

        this.accounts.get(acctIdx).printTransactionHistory();

    }

    public double getAcctBallance(int acctIdx) {
        return this.accounts.get(acctIdx).getBalance();
    }

    /**
     * Get the UUID of a particular account
     *
     * @param acctIdx the index of the account to use
     * @return the UUID of the account
     */

    public String getAcctUUID(int acctIdx) {
        return this.accounts.get(acctIdx).getUUID();
    }

    public void addAccountTransaction(int acctIdx, double amount, String memo) {
        this.accounts.get(acctIdx).addTransaction(amount, memo);
    }
}
