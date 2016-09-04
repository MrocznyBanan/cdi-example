package eu.mrocznybanan.cdi.decoratos;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * From CDI 1.1 activation of @Decorator can be done with @Priority annotation
 * Or you can use the beans.xml
 * Both activation methods should not be used together. 
 */
@Decorator
@Priority(1)
public class JdbcWorkDecorator extends JdbcWork {

    @Inject @Delegate
    JdbcWork work;
    
    @Override
    public void doWork() {
        log.info("Before work execution...");
        super.doWork();
        log.info("After work execution...");
    }

}
