package eu.mrocznybanan.cdi.specializations;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class DefaultConfigProcuder {

    Config defaultConfig;

    @PostConstruct
    public void init() {
        System.out.println("DefaultConfigProcuder");
        defaultConfig = new Config.Builder()
                .withTimeout(5000)
                .withRetries(3)
                .withProfile("test")
                .withAddress("172.20.1.78")
                .build();
    }

    @Produces
    public Config exposeConfig() {
        return defaultConfig;
    }

}
