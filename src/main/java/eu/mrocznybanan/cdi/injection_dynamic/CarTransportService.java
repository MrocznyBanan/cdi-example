package eu.mrocznybanan.cdi.injection_dynamic;

import java.util.logging.Logger;

import javax.inject.Inject;

public class CarTransportService implements TransportService {

    @Inject
    Logger log;
    
    @Override
    public void transport() {
        log.info("Transport with " + this.getClass().getName());
    }

}
