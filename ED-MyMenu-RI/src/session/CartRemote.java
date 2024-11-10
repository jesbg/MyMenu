/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.CartItem;
import javax.ejb.Remote;
import java.util.ArrayList;
import entity.CartItem;


@Remote
public interface CartRemote {
    
    ArrayList<CartItem> getCart();

    public boolean addCartItem(CartItem cartItem);

    boolean deleteCartItem(int itemId);

    boolean updateCartItem(CartItem cartItem);

}