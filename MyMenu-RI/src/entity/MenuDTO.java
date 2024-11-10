/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author jesbg
 */
public class MenuDTO implements Serializable {
    private final int id;
    private final String name;
    private final String description;
    private final String imgfile;
    private final BigDecimal price;

    public MenuDTO(int id, String name,String description, String imgfile, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgfile = imgfile;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public String getImgfile() {
        return imgfile;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
