/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.mymenu.jdbc;

import java.util.ArrayList;

/**
 *
 * @author jesbg
 */
public class EDMyMenuJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // the database object to access the actual database
        UserDB db = new UserDB();
        MenuDB menudb = new MenuDB();

        // make sure no name conflicts
        try {
            db.destroyDBTable();
            menudb.destroyMenuDBTable();
        } catch (Exception ex) {
        }
        

        // create the database table
        System.out.println("Create an empty database table");
//        db.dropUserTable();
        db.createDBTable(); 
        menudb.createMenuDBTable();
        
        
        System.out.println("Add several static records in the database table");
        
        // prepare data
        User user001 = new User("00001", "Adam", "1234567890", "1 John Street, Hawthorn",
                "adam@mymenu.com.au", "password", "ED-APP-ADMIN");
        User user002 = new User("00002", "Bill", "2345678901", "2 Paul Street, Hawthorn",
                "bill@mymenu.com.au", "password", "ED-APP-ADMIN");
        User user003 = new User("00003", "Ceci", "3456789012", "3 Mary Street, Hawthorn",
                "ceci@mymenu.com.au", "password", "ED-APP-USERS");
        User user004 = new User("00004", "Dave", "4567890123", "4 Pete Street, Hawthorn", 
                "dave@mymenu.com.au", "password", "ED-APP-USERS");
        
        
        System.out.println("Add several menu records in the database table");
        
        Menu menu001 = new Menu ("001", "Oysters", "Baked Oysters with Shallot Herb Butter and Prosciutto (2pcs)", "https://umamigirl.com/wp-content/uploads/2022/02/Baked-Oysters-with-Shallot-Herb-Butter-and-Prosciutto-Umami-Girl-1200-4.jpg", "$10");
        Menu menu002 = new Menu ("002", "French Fries", "Garlic cheese french fries", "https://www.savoryexperiments.com/wp-content/uploads/2022/05/Garlic-Cheese-Fries-8-500x375.jpg", "$6");
        Menu menu003 = new Menu ("003", "Chicken Wings", "Buffalo Chicken Wings (5pcs)", "https://www.marionskitchen.com/wp-content/uploads/2023/02/Asian-Buffalo-Wings-02.jpg", "$12");
        Menu menu004 = new Menu ("004", "Croquettes", "Caesar salad cheesy croquettes (2pcs)", "https://media-cdn2.greatbritishchefs.com/media/d4pnkfmw/img42852.jpg", "$9" );
        
        // prepare list
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user001);
        userList.add(user002);
        userList.add(user003);
        userList.add(user004);
        
        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(menu001);
        menuList.add(menu002);
        menuList.add(menu003);
        menuList.add(menu004);
        
        // add data to db
        db.addRecords(userList);
        menudb.addMenuRecords(menuList);
    }
}
