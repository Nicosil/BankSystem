/*
 * bank now contain all of them
 */
package banksystem;

import java.util.ArrayList;

/**
 * Class of a bank
 * @author Nicolas Nguyen
 */
public class Bank {
    private static ArrayList<AutomatedTellerMachine> atms = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();

    /**
     * To add a new user to the user list
     * @param userName the name of the user
     * @param password the pin/password of the user
     */      
    public static void addUser(String userName, String password) {
        users.add(new User(userName, password));
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
