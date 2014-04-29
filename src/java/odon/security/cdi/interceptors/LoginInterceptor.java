package odon.security.cdi.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import odon.security.cdi.annotations.MustBeLoggedIn;
import odon.security.cdi.contexts.MySecurityContext;
import odon.security.exceptions.NotLoggedInException;
   
@MustBeLoggedIn
@Interceptor
public class LoginInterceptor {
    
    @Inject
    private MySecurityContext securityContext;

    @AroundInvoke
    public Object checkIfIsLoggedIn(InvocationContext ctx) throws Exception {                            
        if(securityContext.isLoggedIn()){
            return ctx.proceed();            
        }else{
            throw new NotLoggedInException("There is no logged user.");
        }        
    }
}