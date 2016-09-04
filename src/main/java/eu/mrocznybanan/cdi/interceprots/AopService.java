package eu.mrocznybanan.cdi.interceprots;

import java.util.logging.Logger;

import javax.inject.Inject;

import eu.mrocznybanan.cdi.interceprots.Secured.Role;

@Timing
@Secured(roleAllowed = Role.ADMIN)
public class AopService {

    @Inject
    Logger log;
    
    public void implicitAdminRoleRequired() {
        log.info("implicitAdminRoleRequired");
    }

    @Secured(roleAllowed = Role.ADMIN)
    public void explicitAdminRoleRequired() {
        log.info("explicitAdminRoleRequired");
    }

    @Secured(roleAllowed = Role.USER)
    public void userRoleRequired() {
        log.info("userRoleRequired");
    }

    @Secured(roleAllowed = Role.USER)
    @Transactional
    public void transactionOk() {
        log.info("transactionOk");
    }

    @Secured(roleAllowed = Role.USER)
    @Transactional
    public void transactionWithError() {
        log.info("transactionWithError");
        throw new RuntimeException("Error!");
    }

}
