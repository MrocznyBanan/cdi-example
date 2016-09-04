package eu.mrocznybanan.cdi.injection_dynamic;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import eu.mrocznybanan.cdi.extension_eager.Eager;

@Eager
@ApplicationScoped
public class DynamicInjectionExample {

    @Inject 
    @Chosen
    TransportService service;
    
    @PostConstruct
    public void init() {
        service.transport();
    }
    
}
