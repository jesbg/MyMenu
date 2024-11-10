/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Remote;
import java.util.ArrayList;
import entity.MenuDTO;

/**
 *
 * @author jesbg
 */
public interface MenuFacadeRemote {
    
    boolean checkMenu(int id);

    boolean createRecord(MenuDTO menuDTO);

    MenuDTO getRecord(int id);

    boolean updateRecord(MenuDTO menuDTO);

    boolean deleteRecord(int id);

    List<MenuDTO> menuList();
}
