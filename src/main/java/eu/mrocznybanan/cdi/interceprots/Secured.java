package eu.mrocznybanan.cdi.interceprots;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@Target(value = { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Secured {
    
    @Nonbinding Role roleAllowed() default Role.ADMIN;
    
    public enum Role {
        ADMIN, USER;
    }
}
