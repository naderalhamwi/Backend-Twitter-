/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.te4.userlogin.resources;

/**
 *
 * @author Elev
 */
public class Credential {
    private String username; 
    private String Password; 
    
    public Credential (String username, String password){
        this.username = username;
        this.Password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
