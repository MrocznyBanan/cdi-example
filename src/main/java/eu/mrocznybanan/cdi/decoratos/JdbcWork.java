package eu.mrocznybanan.cdi.decoratos;

import java.util.logging.Logger;

import javax.inject.Inject;

public class JdbcWork implements Work {

    @Inject
    Logger log;
    
    @Override
    public void doWork() {
        log.info("Doing some work...");
    }

}
