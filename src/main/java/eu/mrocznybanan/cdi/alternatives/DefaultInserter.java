package eu.mrocznybanan.cdi.alternatives;

import java.util.logging.Logger;

import javax.inject.Inject;

public class DefaultInserter implements Insertable {

    @Inject
    Logger log;
    
    @Override
    public void insert() {
        log.info("Insert with " + this.getClass().getName());
    }

}
