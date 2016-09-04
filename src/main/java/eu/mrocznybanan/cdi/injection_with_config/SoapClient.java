package eu.mrocznybanan.cdi.injection_with_config;

import java.util.logging.Logger;

public class SoapClient implements Client {

    private Logger log;  
    private int retries;
    private String address;

    public SoapClient(int retries, String address, Logger log) {
        super();
        this.retries = retries;
        this.address = address;
        this.log = log;
    }

    public void invoke() {
        for (int i = 1; i <= retries; i++) {
            log.info("Invoking SOAP client [" + i + "] " + address);
        }
    }

}
