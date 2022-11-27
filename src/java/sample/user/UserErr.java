/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.util.logging.Logger;

/**
 *
 * @author minhq
 */
public class UserErr {
      private String userIDError;
    private String fullnameError;
    private String passwordError;
    private String roleIDError;
     private boolean statusError;
     private String confirmError;

    public UserErr() {
        this.userIDError="";
        this.fullnameError="";
        this.passwordError="";
        this.confirmError="";
        this.roleIDError="";
        this.statusError=false;
    }

    public UserErr(String userIDError, String fullnameError, String passwordError, String roleIDError, boolean statusError, String  confirmError) {
        this.userIDError = userIDError;
        this.fullnameError = fullnameError;
        this.passwordError = passwordError;
        this.roleIDError = roleIDError;
        this.statusError = statusError;
        this.confirmError = confirmError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public boolean isStatusError() {
        return statusError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public void setStatusError(boolean statusError) {
        this.statusError = statusError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

   
    
     
}
