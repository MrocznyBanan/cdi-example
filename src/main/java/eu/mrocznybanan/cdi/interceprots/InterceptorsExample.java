package eu.mrocznybanan.cdi.interceprots;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import eu.mrocznybanan.cdi.extension_eager.Eager;

@Eager
@ApplicationScoped
public class InterceptorsExample {

    @Inject
    AopService service;
    
    @PostConstruct
    public void init() {
        service.explicitAdminRoleRequired();
        service.implicitAdminRoleRequired();
        //
        service.userRoleRequired();
        service.transactionOk();
        service.transactionWithError();
    }
    
}
