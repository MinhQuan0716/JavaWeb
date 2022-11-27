/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

/**
 *
 * @author minhq
 */
public class UserDTO {
    private String userID;
    private String fullname;
    private String password;
    private String roleID;
     private boolean status;

    public UserDTO() {
        this.userID="";
    this.password="";
       this.fullname="";
      this.roleID="";
      this.status=false;
  
                                        
                                        
    }

    public UserDTO(String userID, String fullname, String password, String roleID, boolean status) {
        this.userID = userID;
        this.fullname = fullname;
        this.password = password;
        this.roleID = roleID;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRoleID() {
        return roleID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
          
}
