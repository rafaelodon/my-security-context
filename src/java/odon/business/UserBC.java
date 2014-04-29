package odon.business;

import java.io.Serializable;
import odon.domain.User;
import odon.security.constants.Roles;

public class UserBC implements Serializable {   
    
    public User findUserByLoginAndPassword(String login, String password){
        //Here is the place where you should perform the user retrieval logic. 
        //Return null if no User is found
        User user = null;
        if(login.equals("admin") && password.equals("pass")){
            user = new User();
            user.setLogin(login);
            user.setNome("The Administrator");
        }else
        if(login.equals("odon") && password.equals("pass")){
            user = new User();
            user.setLogin(login);
            user.setNome("Rafael Odon");
        }
        return user;
    }

    public boolean checkIfUserHaveRole(User loggedUser, String role) {
        //Here is the place where you should perform user permissions retrieval logic.        
        return (loggedUser.getLogin().equals("admin") && role.equals(Roles.ADMIN)) ||
               (loggedUser.getLogin().equals("odon") && role.equals(Roles.USER));                
    }
}
