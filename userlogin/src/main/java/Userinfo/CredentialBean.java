/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userinfo;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.te4.userlogin.ConnectionFactory;
import com.te4.userlogin.ConnectionFactory;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

/**
 *
 * @author Elev
 */
@Stateless
public class CredentialBean {
    public Credential createCredential (String basicAuth){
        basicAuth = basicAuth.substring(6).trim();
        
        byte[] bytes = Base64.getDecoder().decode(basicAuth);
        basicAuth = new String(bytes);
        int colon = basicAuth.indexOf(":");
        String username = basicAuth.substring(0, colon);
        String password = basicAuth.substring(colon+1);
        String email = basicAuth.substring(colon+2);
        String phonenumber = basicAuth.substring(colon+3);
        return new Credential(username, password, email, phonenumber);
    }
    
    public int saveCredential(Credential credentials){
        try (Connection con = ConnectionFactory.getConnection()){
            String hashedpassword = BCrypt.withDefaults().hashToString(12, credentials.getPassword().toCharArray());
            Statement stmt = con.createStatement();
            String sql = String.format("INSERT INTO users VALUES ('%s','%s', '%s', '%s')", credentials.getUsername(), hashedpassword, credentials.getEmail(), credentials.getPhonenumber());
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error CredentialBean.saveCredential: " +e.getMessage());
            return 0;
        }
    } 
    
    public boolean checkCredentials(Credential credential){
        try (Connection con = ConnectionFactory.getConnection()){
            Statement stmt = con.createStatement();
            String sql = String.format("SELECT * FROM users WHERE name='%s'", credential.getUsername());
            ResultSet data = stmt.executeQuery(sql);
            if(data.next()){
                String bcryptHashString = data.getString("hashed_password");
                BCrypt.Result result = BCrypt.verifyer().verify(credential.getPassword().toCharArray(), bcryptHashString);
                return result.verified;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    //tarbort
    public int deleteUser(Credential credential){
        try (Connection con = ConnectionFactory.getConnection()){
            Statement stmt = con.createStatement();
            String sql = String.format("DELETE FROM users WHERE email='%s'", credential.getEmail());
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            return 0;
        }
    } 
    
    //ändra 
    public int changeUsser(Credential credential){
        try (Connection con = ConnectionFactory.getConnection()){
            String hashedpassword = BCrypt.withDefaults().hashToString(12, credential.getPassword().toCharArray());
            Statement stmt = con.createStatement();
            String sql = String.format("UPDATE users SET password='%s' WHERE name='%s'", hashedpassword, credential.getUsername());
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            return 0;
        }
    } 
}