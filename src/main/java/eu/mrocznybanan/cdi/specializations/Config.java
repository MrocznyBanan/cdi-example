package eu.mrocznybanan.cdi.specializations;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class Config {

    protected int timeout;
    protected int retries;
    protected String profile;
    protected String address;

    protected Config() {

    }

    public Config(int timeout, int retries, String profile, String address) {
        this.timeout = timeout;
        this.retries = retries;
        this.profile = profile;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Config [timeout=" + timeout + ", retries=" + retries + ", profile=" + profile + ", address=" + address + "]";
    }

    public int getTimeout() {
        return timeout;
    }

    public int getRetries() {
        return retries;
    }

    public String getProfile() {
        return profile;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        Config cfg;

        public Builder() {
            cfg = new Config(1000, 5, "dev", "127.0.0.1");
        }

        public Builder withTimeout(int timeout) {
            cfg.timeout = timeout;
            return this;
        }

        public Builder withRetries(int retries) {
            cfg.retries = retries;
            return this;
        }

        public Builder withProfile(String profile) {
            cfg.profile = profile;
            return this;
        }

        public Builder withAddress(String address) {
            cfg.address = address;
            return this;
        }

        public Config build() {
            return cfg;
        }
    }

}
