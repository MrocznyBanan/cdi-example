package eu.mrocznybanan.cdi.alternatives;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import eu.mrocznybanan.cdi.extension_eager.Eager;

@Eager
@ApplicationScoped
public class AlternativeExample {

    @Inject 
    Insertable insertable;
    
    @PostConstruct
    public void init() {
        insertable.insert();
    }
    
}
