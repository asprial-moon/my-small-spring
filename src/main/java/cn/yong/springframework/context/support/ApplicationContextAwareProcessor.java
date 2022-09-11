package cn.yong.springframework.context.support;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.config.BeanPostProcessor;
import cn.yong.springframework.context.ApplicationContext;
import cn.yong.springframework.context.ApplicationContextAware;

/**
 * <p>将ApplicationContext 、 Environment或StringValueResolver提供给实现EnvironmentAware 、 EmbeddedValueResolverAware 、 ResourceLoaderAware 、 ApplicationEventPublisherAware 、MessageSourceAware和/或ApplicationContext接口的BeanPostProcessor ApplicationContextAware 。
 * <p>实现的接口按照上面提到的顺序得到满足。
 * @author Line
 * @date 2022/9/11
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
