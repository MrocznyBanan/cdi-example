package eu.mrocznybanan.cdi.injection_with_config;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import eu.mrocznybanan.cdi.extension_eager.Eager;
import eu.mrocznybanan.cdi.injection_with_config.ClientConfig.ClientType;

@Eager
@ApplicationScoped
public class InjectionWithConfigExample {

    @Inject
    @ClientConfig(type = ClientType.REST, retries = 10)
    Client restClient;
    
    @Inject
    @ClientConfig(type = ClientType.SOAP, retries = 5, address = "http://test.pl/cdi/api")
    Client soapClient;
    
    @PostConstruct
    public void init() {
        restClient.invoke();
        soapClient.invoke();
    }
    
}
