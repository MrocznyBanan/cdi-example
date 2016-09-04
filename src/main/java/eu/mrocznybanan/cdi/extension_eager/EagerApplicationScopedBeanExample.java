package eu.mrocznybanan.cdi.extension_eager;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Eager
@ApplicationScoped
public class EagerApplicationScopedBeanExample {
    
    @Inject
    Logger log;

    @PostConstruct
    public void init() {
        log.info("Hello from eager application scoped bean ;-)");
    }

}
