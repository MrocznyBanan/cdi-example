package eu.mrocznybanan.cdi.decoratos;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import eu.mrocznybanan.cdi.extension_eager.Eager;

@Eager
@ApplicationScoped
public class DecoratorExample {

    @Inject 
    JdbcWork work;
    
    @PostConstruct
    public void init() {
        work.doWork();
    }
    
}
