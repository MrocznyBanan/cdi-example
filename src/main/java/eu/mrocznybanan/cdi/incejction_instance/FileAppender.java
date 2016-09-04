package eu.mrocznybanan.cdi.incejction_instance;

import java.util.logging.Logger;

import javax.inject.Inject;

public class FileAppender implements Appender {
    
    @Inject
    Logger log;
    
    @Override
    public void append(String msg) {
        log.info("File appender " + msg);
    };
    
}
