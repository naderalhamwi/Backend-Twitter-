/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.te4.userlogin;

import com.google.gson.Gson;
import com.te4.userlogin.resources.Credential;
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
    public Response checkUser(@HeaderParam("Authorization") String Authorization){
        Credential credential = credentialBean.createCredential(Authorization);
        if(credentialBean.checkCredentials(credential)){
            return Response.ok("Welcome to our sectrer res api").build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    @POST
    public Response createUser(@HeaderParam("Authorization") String Authorization){
        Credential credential = credentialBean.createCredential(Authorization);
        if(credentialBean.saveCredential(credential) == 1){
           return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    @DELETE
    public Response deleteUser(@HeaderParam("Authorization") String Authorization){
        Credential credential = credentialBean.createCredential(Authorization);
        if(credentialBean.deleteUser(credential) == 1){
            return Response.ok("Welcome to our sectrer res api").build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    @PUT
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response changeUsser(String Passowrd, @HeaderParam("Authorization") String Authorization){
        //Gson gson = new Gson();
        //Credential credential = gson.fromJson(Passowrd, Credential.class);
        
        Credential credential = credentialBean.createCredential(Authorization);
        
        System.out.println(credential.getUsername());
        
        if(credentialBean.changeUsser(credential) == 1){
            return Response.ok("Welcome to our sectrer res api").build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}

