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
    
    boolean checkMenu(String id);

    boolean createRecord(MenuDTO menuDTO);

    MenuDTO getRecord(String id);

    boolean updateRecord(MenuDTO menuDTO);

    boolean deleteRecord(String id);

    List<MenuDTO> menuList();
}
