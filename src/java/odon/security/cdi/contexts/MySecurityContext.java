package odon.security.cdi.contexts;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import odon.business.UserBC;
import odon.domain.User;
import odon.security.exceptions.InvalidLoginException;

@SessionScoped
@Named
public class MySecurityContext implements Serializable {
    
    private User loggedUser = null;
    
    @Inject
    private UserBC userBC;
    
    public void doLogin(final String login, final String senha){        
        loggedUser = userBC.findUserByLoginAndPassword(login, senha);        
        if(loggedUser == null){
            throw new InvalidLoginException("Invalid user/password.");
        }
    }
    
    public void doLogout(){
        loggedUser = null;
    }
    
    public boolean isLoggedIn(){
        return loggedUser != null;
    }
    
    public User getLoggedUser(){
        return loggedUser;
    }
    
    public boolean hasRole(String role){
        return userBC.checkIfUserHaveRole(loggedUser, role);
    }
}
