package eu.mrocznybanan.cdi.injection_dynamic;

import javax.enterprise.inject.Produces;


public class ServiceProducer {
  
    /*
     * -Dtransport.type=PLANE
     */    
    @Produces
    @Chosen
    public TransportService exposeService(PlaneTransportService planeTransport, CarTransportService carTransport) {
        if("PLANE".equals(System.getProperty("transport.type"))) {
            return planeTransport;
        } else {
            return carTransport;
        }         
    }
    
}
