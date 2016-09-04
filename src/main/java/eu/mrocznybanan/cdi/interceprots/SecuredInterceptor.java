package eu.mrocznybanan.cdi.interceprots;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import eu.mrocznybanan.cdi.interceprots.Secured.Role;

@Secured
@Interceptor
@Priority(1)
public class SecuredInterceptor {

    @Inject
    Logger log;
    
    @AroundInvoke
    public Object manageSecurity(InvocationContext ctx) throws Exception {
        Secured securedAnnotation = ctx.getMethod().getAnnotation(Secured.class);
        if(securedAnnotation == null) {
            securedAnnotation = ctx.getClass().getAnnotation(Secured.class);
        }
        if(securedAnnotation != null && Role.ADMIN == securedAnnotation.roleAllowed()) {
            log.info("SecuredInterceptor -> Access denied!");
            return null;
        }
        return ctx.proceed();
    }

}
