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
public class CartItem {
    
    private int itemId;
    private String menuName;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal subTotal;

    public BigDecimal getSubTotal() {
        return subTotal;
    }


    public CartItem(int itemId, String menuName, BigDecimal unitPrice, int quantity) {
        this.itemId = itemId;
        this.menuName = menuName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setFoodName(String menuName) {
        this.menuName = menuName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
