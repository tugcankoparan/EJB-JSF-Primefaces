package com.jsf_login.EJB;

import com.jsf_login.Entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
public class LoginEJB {
    
    @PersistenceContext(name="JSF_LOGIN_PU")
    private EntityManager em;

    public Users loginControl(String userName, String password) {
        Query query;
        List userList = null;
        try
        {
            query = em.createNamedQuery("xUserNameAndyPassword").setParameter("userName", userName).setParameter("password", password);
            
            userList = query.getResultList();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        if(userList!=null)
            return (Users) userList.get(0);
        else 
            return null;
    }
    
}
