package odon.ui.managedbean;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import odon.business.ExampleBC;
import odon.security.cdi.contexts.MySecurityContext;

@ManagedBean
public class ExampleMB {
    
    public String username;
    public String password;           
    
    @Inject
    private MySecurityContext mySecurityContext;
    
    @Inject
    private ExampleBC testeBC;
    
    public void onClickTestLogin(){
        testeBC.someProtectedTask();
    }
    
    public void onClickTestAdminRole(){
        testeBC.someAdministrativeTask();
    }
    
    public void onClickLogin(){
        mySecurityContext.doLogin(username, password);
    }
    
    public void onClickLogout(){
        mySecurityContext.doLogout();
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

    public void setPassword(String password) {
        this.password = password;
    }
                
    public boolean isLoggedIn(){
        return mySecurityContext.isLoggedIn();
    }
    
    public String getUserFullName(){
        return mySecurityContext.getLoggedUser().getNome();
    }
}    
