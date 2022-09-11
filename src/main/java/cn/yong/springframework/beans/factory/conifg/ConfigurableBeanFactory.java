package cn.yong.springframework.beans.factory.conifg;

import cn.yong.springframework.beans.factory.HierarchicalBeanFactory;

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

}
