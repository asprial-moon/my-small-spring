package cn.yong.springframework.beans.factory.config;

import cn.yong.springframework.beans.factory.HierarchicalBeanFactory;
import cn.yong.springframework.util.StringValueResolver;

/**
 * @author Line
 * @desc Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link cn.yong.springframework.beans.factory.BeanFactory}
 * interface.
 * @date 2022/9/11
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 添加后置处理器
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

    /**
     * Add a String resolver for embedded values such as annotation attributes.
     * @param valueResolver the String resolver to apply to embedded values
     * @since 3.0
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * Resolve the given embedded value, e.g. an annotation attribute.
     * @param value the value to resolve
     * @return the resolved value (may be the original value as-is)
     * @since 3.0
     */
    String resolveEmbeddedValue(String value);
}
