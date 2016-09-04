package eu.mrocznybanan.cdi.alternatives;

import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Alternative
public class DatabaseInserter implements Insertable {

    @Inject
    Logger log;
    
    @Override
    public void insert() {
        log.info("Insert with " + this.getClass().getName()); 
    }

}
