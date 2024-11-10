/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.MenuDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import session.MenuFacade;
import session.MenuFacadeRemote;

/**
 *
 * @author jesbg
 */
@Named(value = "menuManagedBean")
@SessionScoped
public class MenuManagedBean implements Serializable {

    @Inject
    private Conversation conversation;
    @EJB
    private MenuFacadeRemote menuFacade;

    private int id;
    private String name;
    private String description;
    private String imgfile;
    private BigDecimal price;

    private List<MenuDTO> menuList = new ArrayList<MenuDTO>();

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }

    public void MenuList() {
        menuList = menuFacade.menuList();
    }
    
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Creates a new instance of MenuManagedBean
     */
    public MenuManagedBean() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.imgfile = null;
        this.price = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgfile() {
        return imgfile;
    }

    public void setImgfile(String imgfile) {
        this.imgfile = imgfile;
    }

  //-------------------------------------------------------------------------
    public String addMenu() {

        // all information seems to be valid
        // try add the employee
        MenuDTO menuDTO = new MenuDTO(id, name, description, imgfile, price);
        boolean result = menuFacade.createRecord(menuDTO);
        if (result) {
            return "success";
        } else {
            return "failure";
        }
    }

    public String editDetails() {
        // check empId is null
        MenuDTO menuDTO = new MenuDTO(id, name, description, imgfile, price);
        boolean result = menuFacade.updateRecord(menuDTO);

        if (result) {
            return "success";
        } else {
            return "failure";
        }
    }

    public String deleteMenu() {
        // check empId is null
        boolean result = menuFacade.deleteRecord(id);
        if (result) {
            return "success";
        } else {
            return "failure";
        }
    }

    public String checkMenu() {
        if (menuFacade.checkMenu(id)) {
            return "success";
        }
        return "failure";
    }

    public String displayMenu() {
        return setMenuDetails();
    }

    private String setMenuDetails() {

        if (id == 0 || conversation == null) {
            return "debug";
        }

        MenuDTO menu = menuFacade.getRecord(id);

        if (menu == null) {
            // no such employee
            return "failure";
        } else {
            // found - set details for display
            this.id = menu.getId();
            this.name = menu.getName();
            this.description = menu.getDescription();
            this.imgfile = menu.getImgfile();
            this.price = menu.getPrice();
            return "success";
        }
    }

}
