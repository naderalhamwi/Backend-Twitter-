/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userinfo;

import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Elev
 */
@Path("user")
public class CredentialResource {
    
    @EJB
    CredentialBean credentialBean;
    
    @GET
    public Response checkUser(@HeaderParam("Authorization") String authorization){
        Credential credential = credentialBean.createCredential(authorization);
        System.out.println(credential.getEmail());
        System.out.println(credential.getPassword());
        if(credentialBean.checkCredentials(credential)){
            return Response.ok("Welcome to our sectrer res api").build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response createUserJson(String Passowrd){
        Gson gson = new Gson();
        Credential credential = gson.fromJson(Passowrd, Credential.class);
        
        if(credentialBean.saveCredential(credential) == 1){
           //return Response.status(Response.Status.CREATED).build();
           return Response.ok().header("Access-Control-Allow-Origin","*").build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    public Response deleteUser(String email){
        Gson gson = new Gson();
        Credential credential = gson.fromJson(email, Credential.class);
        if(credentialBean.deleteUser(credential) == 1){
            return Response.ok("Welcome to our sectrer res api").build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response changeUsserJson(String user){
        Gson gson = new Gson();
        Credential credential = gson.fromJson(user, Credential.class);
        
        //Credential credential = credentialBean.createCredential(Authorization);
        
        
        
        if(credentialBean.changeUsser(credential) == 1){
            return Response.ok("Welcome to our sectrer res api").build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}

