/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.ArrayList;

/**
 *
 * @author jesbg
 */
public class SetupUserDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // the database object to access the actual database
        UserDB db = new UserDB();

        // make sure no name conflicts
        try {
            db.destroyDBTable();
        } catch (Exception ex) {
        }

        // create the database table
        System.out.println("Create an empty database table Employee");
        db.createDBTable();
        
        System.out.println("Add several static records in the database table");
        
        // prepare data
        // 11111111
        User user001 = new User("00001", "Adam", "1234567890", "1 John Street, Hawthorn",
                "adam@mymenu.com.au", "password", "ED-APP-ADMIN");
        // 22222222
        User user002 = new User("00002", "Bill", "2345678901", "2 Paul Street, Hawthorn",
                "bill@mymenu.com.au", "password", "ED-APP-ADMIN");
        // 33333333
        User user003 = new User("00003", "Ceci", "3456789012", "3 Mary Street, Hawthorn",
                "ceci@mymenu.com.au", "password", "ED-APP-USERS");
        //44444444
        User user004 = new User("00004", "Dave", "4567890123", "4 Pete Street, Hawthorn", 
                "dave@mymenu.com.au", "password", "ED-APP-USERS");
        
        // prepare list
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user001);
        userList.add(user002);
        userList.add(user003);
        userList.add(user004);
        
        // add data to db
        db.addRecords(userList);
    }
}
