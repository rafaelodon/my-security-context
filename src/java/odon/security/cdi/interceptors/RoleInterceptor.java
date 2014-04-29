package odon.security.cdi.interceptors;

import odon.security.exceptions.RoleNotPresentException;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import odon.security.cdi.annotations.MustHaveRole;
import odon.security.cdi.contexts.MySecurityContext;
import odon.security.exceptions.NotLoggedInException;

@Interceptor
@MustHaveRole
public class RoleInterceptor {

    @Inject
    private MySecurityContext securityContext;

    @AroundInvoke
    public Object checkIfIsLoggedIn(InvocationContext ctx) throws Exception {
        if (securityContext.isLoggedIn()) {
            MustHaveRole annotation = ctx.getMethod().getAnnotation(MustHaveRole.class);
            if (annotation != null) {
                for (String role : annotation.roles()) {
                    if (!securityContext.hasRole(role)) {                                            
                        throw new RoleNotPresentException("The logged user doesn't have permission to perform this task.");
                    }
                }                
            }
            return ctx.proceed();
        } else {
            throw new NotLoggedInException("There is no logged user.");
        }
    }
}