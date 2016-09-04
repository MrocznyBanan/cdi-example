package eu.mrocznybanan.cdi.interceprots;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Transactional
@Interceptor
@Priority(10)
public class TransactionalInterceptor {

    @Inject
    Logger log;
    
    @AroundInvoke
    public Object manageTransaction(InvocationContext ctx) throws Exception {
        log.info("TransactionalInterceptor -> NEW TRANSACTION");
        boolean doCommit = true; 
        try {
            return ctx.proceed();
        } catch (Exception e) {
            doCommit = false;
            log.info("TransactionalInterceptor -> Rollback;");    
            return null;
        } finally {
            if(doCommit) {
                log.info("TransactionalInterceptor -> Commit;");
            }            
        }
    }
    
}
