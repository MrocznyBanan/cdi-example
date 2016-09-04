package eu.mrocznybanan.cdi.specializations;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;

@Specializes
public class OverridenConfigProducer extends DefaultConfigProcuder {

    @PostConstruct
    public void init() {
        System.out.println("OverridenConfigProducer");
        defaultConfig = new Config.Builder()
                .withTimeout(1000)
                .withRetries(5)
                .withProfile("stage")
                .withAddress("100.103.1.78")
                .build();
    }

    @Produces
    public Config exposeConfig() {
        return defaultConfig;
    }

}
