package odon.security.exceptions;

public class InvalidLoginException extends AuthenticationException {

    public InvalidLoginException(String msg) {
        super(msg);
    }
    
}
