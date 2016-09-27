FROM airhacks/wildfly
MAINTAINER Mroczny Banan, mrocznybanan.eu
COPY ./target/cdi.war ${DEPLOYMENT_DIR}