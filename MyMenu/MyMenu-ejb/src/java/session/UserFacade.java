/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.User;
import entity.UserDTO;
import entity.Menu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jesbg
 */
@Stateless
public class UserFacade implements UserFacadeRemote {

    @PersistenceContext(unitName = "MyMenu-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    private void create(User user) {
        em.persist(user);
    }

    private void edit(User user) {
        em.merge(user);
    }

    private void remove(User user) {
        em.remove(em.merge(user));
    }

    private User find(Object id) {
        return em.find(User.class, id);
    }

    private User myDTO2DAO(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAppGroup(userDTO.getAppGroup());
        return user;
    }

    @Override
    public boolean checkUser(String userID) {
        if (find(userID) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean createRecord(UserDTO userDTO) {
        if (find(userDTO.getId()) != null) {
// user whose userid can be found
            return false;
        }
// user whose userid could not be found
        try {
            User user = this.myDTO2DAO(userDTO);
            this.create(user); // add to database
            return true;
        } catch (Exception ex) {
            return false; // something is wrong, should not be here though
        }
    }

    private UserDTO myDAO2DTO(User user) {
        String id = user.getId();
        String name = user.getName();
        String phone = user.getPhone();
        String address = user.getAddress();
        String email = user.getEmail();
        String password = user.getPassword();
        String appgroup = user.getAppGroup();
        UserDTO userDTO = new UserDTO(id, name, phone, address, email, password, appgroup);
        return userDTO;
    }

    @Override
    public UserDTO getRecord(String userID) {
        User user = new User();
        user = find(userID);
        if (user != null) {
            // can find a customer with the same custid

            UserDTO userDTO = myDAO2DTO(user);
            // System.out.println(id + userName + userPass + userEmail + userPhone + userAdd + qn + ans);
            return userDTO;
        } else {
            System.out.println("no user found");
            return null;
        }
    }

    @Override
    public boolean updateRecord(UserDTO userDTO) {
        boolean result = false;

        User user = em.find(User.class, userDTO.getId());

        if (user == null) {
            result = false;
        } else {
            try {
                user = this.myDTO2DAO(userDTO);
                em.merge(user);
                result = true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public boolean updatePassword(String id, String password) {
        // find the employee
        User user = find(id);

        // check again - just to play it safe
        if (user == null) {
            return false;
        }

        // only need to update the password field
        user.setPassword(password);
        return true;
    }

    @Override
    public boolean deleteRecord(String userID) {
        boolean result = false;

        User user = em.find(User.class, userID);

        if (user == null) {
            // cannot find a customer - cannot delete
            result = false;
        } else {
            // can now remove the customer found
            try {
                em.remove(user);

                result = true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
