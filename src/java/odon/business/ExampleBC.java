package odon.business;

import odon.security.cdi.annotations.MustBeLoggedIn;
import odon.security.cdi.annotations.MustHaveRole;

public class ExampleBC {
    
    @MustBeLoggedIn
    public void someProtectedTask(){
        System.out.println("Success!");
    }    
        
    @MustHaveRole(roles={"ADMIN"})
    public void someAdministrativeTask(){
        System.out.println("Success!");
    }
}
