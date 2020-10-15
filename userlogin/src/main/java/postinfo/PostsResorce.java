/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postinfo;

import Userinfo.CredentialBean;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 *
 * @author Elev
 */
@Path("UsersPosts")
public class PostsResorce {
    
    @EJB   
    Post post;
    
    //@GET
    //@POST
    //@PUT
    //@DELETE
    
    
}
