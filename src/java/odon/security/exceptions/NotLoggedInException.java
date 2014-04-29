package odon.security.exceptions;

public class NotLoggedInException extends AuthenticationException {

    public NotLoggedInException(String msg) {
        super(msg);
    }
    
}
