package eu.mrocznybanan.cdi.injection_with_config;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import eu.mrocznybanan.cdi.injection_with_config.ClientConfig.ClientType;

public class ClientProducer {

    @Produces
    @ClientConfig(type = ClientType.SOAP)
    public Client exposeSoapClient(InjectionPoint injectionPoint) {
        int retries = getRetries(injectionPoint);
        String address = getAddress(injectionPoint);
        //
        return new SoapClient(retries, address, Logger.getLogger(SoapClient.class.getName()));
    }

    @Produces
    @ClientConfig(type = ClientType.REST)
    public Client exposeRestClient(InjectionPoint injectionPoint) {
        int retries = getRetries(injectionPoint);
        String address = getAddress(injectionPoint);
        //
        return new RestClient(retries, address, Logger.getLogger(RestClient.class.getName()));
    }

    private int getRetries(InjectionPoint injectionPoint) {
        return getAnnotation(injectionPoint).retries();
    }

    private String getAddress(InjectionPoint injectionPoint) {
        return getAnnotation(injectionPoint).address();
    }

    private ClientConfig getAnnotation(InjectionPoint injectionPoint) {
        return injectionPoint.getAnnotated().getAnnotation(ClientConfig.class);
    }

}
