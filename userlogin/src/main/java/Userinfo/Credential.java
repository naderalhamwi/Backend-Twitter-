/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userinfo;

/**
 *
 * @author Elev
 */
public class Credential {
    private String username; 
    private String password; 
    private String email;
    private String phonenumber;

    public Credential() {
    }

    public Credential(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Credential(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Credential(String username, String password, String email, String phonenumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
