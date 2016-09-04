package eu.mrocznybanan.cdi.specializations;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import eu.mrocznybanan.cdi.extension_eager.Eager;

@Eager
@ApplicationScoped
public class SpecializationExample {

    @Inject
    Logger log;

    @Inject
    Config config;

    @PostConstruct
    public void init() {
        log.info(this.getClass().getName() + " config = " + config);
    }

}
