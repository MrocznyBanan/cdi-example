package eu.mrocznybanan.cdi.extension_eager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.util.AnnotationLiteral;

/*
 * Remember to create a file
 * src/main/resources/META-INF/services/javax.enterprise.inject.spi.Extension
 * and register this extension in it 
 * eu.mrocznybanan.cdi.eager.EagerCdiExtension
 */
public class EagerCdiExtension implements Extension {

    @SuppressWarnings("serial")
    public void afterDeploymentValidation(@Observes AfterDeploymentValidation event, BeanManager beanManager) {
        beanManager.getBeans(Object.class, new AnnotationLiteral<Eager>() {})
                .stream()
                .filter(bean -> bean.getBeanClass().isAnnotationPresent(ApplicationScoped.class))
                .forEach(bean -> beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean)).toString());
    }
    
}
