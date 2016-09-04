package eu.mrocznybanan.cdi.incejction_instance;

import java.util.logging.Logger;

import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;

@Vetoed
public class VetoedAppender implements Appender {
    
    @Inject
    Logger log;
    
    @Override
    public void append(String msg) {
        log.info("Vetoed appender " + msg);
    };
    
}
