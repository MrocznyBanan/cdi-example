package eu.mrocznybanan.cdi.incejction_instance;

import java.util.logging.Logger;

import javax.inject.Inject;

public class DbAppender implements Appender {

    @Inject
    Logger log;
    
    @Override
    public void append(String msg) {
        log.info("Db appender " + msg);
    };

}
