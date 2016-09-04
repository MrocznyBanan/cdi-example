package eu.mrocznybanan.cdi.injection_dynamic;

import java.util.logging.Logger;

import javax.inject.Inject;

public class PlaneTransportService implements TransportService {

    @Inject
    Logger log;

    @Override
    public void transport() {
        log.info("Transport with " + this.getClass().getName());
    }

}
