/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Remote;
import entity.UserDTO;


@Remote
public interface UserFacadeRemote {
   public boolean checkUser(String userID);

    public boolean createRecord(UserDTO userDTO);

    public UserDTO getRecord(String userID);

    public boolean updateRecord(UserDTO userDTO);
    
    public boolean updatePassword(String id, String password);

    public boolean deleteRecord(String userID);
}
