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
@Table(name = "MYMENU_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MYMENU_USER.findAll", query = "SELECT m FROM MYMENU_USER m"),
    @NamedQuery(name = "MYMENU_USER.findById", query = "SELECT m FROM MYMENU_USER m WHERE m.id = :id"),
    @NamedQuery(name = "MYMENU_USER.findByName", query = "SELECT m FROM MYMENU_USER m WHERE m.name = :name"),
    @NamedQuery(name = "MYMENU_USER.findByPhone", query = "SELECT m FROM MYMENU_USER m WHERE m.phone = :phone"),
    @NamedQuery(name = "MYMENU_USER.findByAddress", query = "SELECT m FROM MYMENU_USER m WHERE m.address = :address"),
    @NamedQuery(name = "MYMENU_USER.findByEmail", query = "SELECT m FROM MYMENU_USER m WHERE m.email = :email"),
    @NamedQuery(name = "MYMENU_USER.findByPassword", query = "SELECT m FROM MYMENU_USER m WHERE m.password = :password"),
    @NamedQuery(name = "MYMENU_USER.findByAppgroup", query = "SELECT m FROM MYMENU_USER m WHERE m.appgroup = :appgroup")})
public class User implements Serializable {

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
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 10)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 30)
    @Column(name = "ADDRESS")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 64)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 12)
    @Column(name = "APPGROUP")
    private String appgroup;

    public User() {
    }

    public User(String id) {
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

    public String getAppgroup() {
        return appgroup;
    }

    public void setAppgroup(String appgroup) {
        this.appgroup = appgroup;
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
        return "entity.MYMENU_USER[ id=" + id + " ]";
    }
    
}
