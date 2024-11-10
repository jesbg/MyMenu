/*
 * To change this template, choose Tools | Templates
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
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "USER_MANAGEMENT", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT e FROM User e"),
    @NamedQuery(name = "User.findByEmpid", query = "SELECT e FROM User e WHERE e.empid = :id"),
    @NamedQuery(name = "User.findByName", query = "SELECT e FROM User e WHERE e.name = :name"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT e FROM User e WHERE e.phone = :phone"),
    @NamedQuery(name = "User.findByAddress", query = "SELECT e FROM User e WHERE e.address = :address"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT e FROM User e WHERE e.email = :email"),   
    @NamedQuery(name = "User.findByPassword", query = "SELECT e FROM User e WHERE e.password = :password"),
    @NamedQuery(name = "User.findByAppGroup", query = "SELECT e FROM User e WHERE e.appGroup = :appGroup"),   })
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "APPGROUP")
    private String appGroup;
  

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String name, String phone, String address, String email, String password, String appGroup) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
        this.appGroup = appGroup;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppGroup() {
        return appGroup;
    }

    public void setAppGroup(String appGroup) {
        this.appGroup = appGroup;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.entity.User[ id=" + id + " ]";
    }
 
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
