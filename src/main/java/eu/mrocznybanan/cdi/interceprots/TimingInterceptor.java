package eu.mrocznybanan.cdi.interceprots;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Secured
@Interceptor
@Priority(100)
public class TimingInterceptor {
    
    @Inject
    Logger log;

    @AroundInvoke
    public Object logExecutionTime(InvocationContext ctx) throws Exception {        
        Object ret = null;
        Instant start, end;
        start = Instant.now();        
        try {
            ret = ctx.proceed();
        } finally {
            end = Instant.now();
            long executionTimeMillis = Duration.between(start, end).toMillis();        
            log.info("[[[ " + ctx.getMethod().getName() + " method execution time -> " + executionTimeMillis + " ms ]]]");            
        }
        return ret;
    }

}
