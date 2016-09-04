package eu.mrocznybanan.cdi.incejction_instance;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import eu.mrocznybanan.cdi.extension_eager.Eager;

@Eager
@ApplicationScoped
public class InstanceInjectionExample {

    @Inject
    Logger log;
    
    @Inject
    @Any
    Instance<Appender> allAppenders;

    @Inject
    @Unsatisfied
    Instance<Appender> usatisfiedAppender;

    @PostConstruct
    public void init() {
        if (usatisfiedAppender.isUnsatisfied()) {
            log.info("This appender shouldn't be injected.");
        }
        //
        allAppenders.forEach(l -> l.append("[custom message]"));
    }

}
