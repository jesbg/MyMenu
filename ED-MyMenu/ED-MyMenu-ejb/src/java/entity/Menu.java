/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesbg
 */
@Entity
@Table(name = "MYMENU_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MYMENU_MENU.findAll", query = "SELECT m FROM MYMENU_MENU m"),
    @NamedQuery(name = "MYMENU_MENU.findById", query = "SELECT m FROM MYMENU_MENU m WHERE m.id = :id"),
    @NamedQuery(name = "MYMENU_MENU.findByName", query = "SELECT m FROM MYMENU_MENU m WHERE m.name = :name"),
    @NamedQuery(name = "MYMENU_MENU.findByDescription", query = "SELECT m FROM MYMENU_MENU m WHERE m.description = :description"),
    @NamedQuery(name = "MYMENU_MENU.findByImagefile", query = "SELECT m FROM MYMENU_MENU m WHERE m.imagefile = :imagefile"),
    @NamedQuery(name = "MYMENU_MENU.findByPrice", query = "SELECT m FROM MYMENU_MENU m WHERE m.price = :price")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ID")
    private String id;
    @Size(max = 25)
    @Column(name = "NAME")
    private String name;
    @Size(max = 300)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 200)
    @Column(name = "IMAGEFILE")
    private String imagefile;
    @Size(max = 30)
    @Column(name = "PRICE")
    private String price;

    public Menu() {
    }

    public Menu(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MYMENU_MENU[ id=" + id + " ]";
    }
    
}
