/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Menu;
import entity.MenuDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jesbg
 */
@Stateless
public class MenuFacade implements MenuFacadeRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
      @PersistenceContext(unitName = "ED-MyMenu-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    private void create(Menu menu) {
        //em.createQuery("Select m from Movie m");
        em.persist(menu);
    }

    private void edit(Menu menu) {
        em.merge(menu);
    }

    private void remove(Menu menu) {
        em.remove(em.merge(menu));
    }

    private Menu find(Object id) {
        return em.find(Menu.class, id);
    }

    @Override
    public List<MenuDTO> menuList() {
        List<Menu> listMenu = em.createNamedQuery("Menu.findAll").getResultList();
        List<MenuDTO> listMenuDTO = new ArrayList<>();

        for (Menu menu : listMenu) {
            MenuDTO menuDTO = myDAO2DTO(menu);
            listMenuDTO.add(menuDTO);
        }
        return listMenuDTO;
    }

    private Menu myDTO2DAO(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setId(menuDTO.getId());
        menu.setName(menuDTO.getName());
        menu.setDescription(menuDTO.getDescription());
        menu.setImagefile(menuDTO.getImgfile());
        menu.setPrice(menuDTO.getPrice().toString());
        return menu;
    }

    @Override
    public boolean checkMenu(String id) {
        if (find(id) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean createRecord(MenuDTO menuDTO) {
        if (find(menuDTO.getId()) != null) {
// user whose userid can be found
            return false;
        }
// user whose userid could not be found
        try {
            Menu menu = this.myDTO2DAO(menuDTO);
            this.create(menu); // add to database
            return true;
        } catch (Exception ex) {
            return false; // something is wrong, should not be here though
        }
    }

    private MenuDTO myDAO2DTO(Menu menu) {
        String id = menu.getId();
        String name = menu.getName();
        String description = menu.getDescription();
        String imgfile = menu.getImagefile();
        String price = menu.getPrice();
        MenuDTO menuDTO = new MenuDTO(id, name, description, imgfile, new BigDecimal(price));
        return menuDTO;
    }
    

    @Override
    public MenuDTO getRecord(String id) {
        Menu menu = new Menu();
        menu = find(id);
        if (menu != null) {
            // can find a customer with the same custid

            MenuDTO menuDTO = myDAO2DTO(menu);
            // System.out.println(id + userName + userPass + userEmail + userPhone + userAdd + qn + ans);
            return menuDTO;
        } else {
            System.out.println("no menu found");
            return null;
        }
    }

    @Override
    public boolean updateRecord(MenuDTO menuDTO) {
        boolean result = false;

        Menu menu = em.find(Menu.class, menuDTO.getId());

        if (menu == null) {
            result = false;
        } else {
            try {
                menu = this.myDTO2DAO(menuDTO);
                em.merge(menu);
                result = true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public boolean deleteRecord(String id) {
        boolean result = false;

        Menu menu = em.find(Menu.class, id);

        if (menu == null) {
            // cannot find a customer - cannot delete
            result = false;
        } else {
            // can now remove the customer found
            try {
                em.remove(menu);

                result = true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
