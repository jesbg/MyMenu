/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.mymenu.jdbc;

import java.io.Serializable;

/**
 *
 * @author jesbg
 */
public class Menu implements Serializable{
    private final String id;
    private final String name;
    private final String description;
    private final String imagefile;
    private final String price;

    public Menu(String id, String name, String description, String imagefile, String price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagefile = imagefile;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagefile() {
        return imagefile;
    }

    public String getPrice() {
        return price;
    }
    
    
}
