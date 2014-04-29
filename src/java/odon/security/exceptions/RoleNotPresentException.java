package odon.security.exceptions;

public class RoleNotPresentException extends AuthorizationException {

    public RoleNotPresentException(String msg) {
        super(msg);
    }
    
}
