import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;

    private ArrayList<User> users;

    private ArrayList<Account> accounts;

    /**
     * Create a new bank object with empty lists of users and accounts
     *
     * @param name the name of the Bank
     */
    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Generate a new universally unique ID for a user
     *
     * @return the uuid
     */

    public String getNewUserUUID() {

        //initialisation
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        //continue loopint ntil we get a unique ID
        do {

            //generate a number
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //check if its unique
            nonUnique = false;
            for (User u : this.users) {
                if (uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);
        return uuid;

    }

    public String getNewAccountUUID() {
        //initialisation
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;

        //continue looping until we get a unique ID
        do {

            //generate a number
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //check if its unique
            nonUnique = false;
            for (Account a : this.accounts) {
                if (uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);
        return uuid;

    }

    public void addAccount(Account anAccount) {
        this.accounts.add(anAccount);
    }

    public User addUser(String firstName, String lastName, String pin) {

        //create a new User object and add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        //create a savings account for the user and add to User and Bank
        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);
        return newUser;
    }

    /**
     * Get the User object associated with a particular userID and pin,, if they are void
     *
     * @param userID the UUID of the user to log in
     * @param pin    the pin of the User
     * @return the user object if the login is successful, or null if its not
     */
    public User userLogin(String userID, String pin) {

        //search through list of users
        for (User u : this.users) {
            //check user ID is correct
            if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Get name of the Bank
     *
     * @return Bank name
     */
    public String getName() {
        return this.name;
    }
}
