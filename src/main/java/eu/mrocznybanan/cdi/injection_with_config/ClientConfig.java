package eu.mrocznybanan.cdi.injection_with_config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

@Qualifier
@Target(value = { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ClientConfig {

    ClientType type() default ClientType.REST;
    
    @Nonbinding int retries() default 5;
    
    @Nonbinding String address() default "http://localhost:8080/cdi/ws";
    
    enum ClientType {
        SOAP, REST;
    }
}
