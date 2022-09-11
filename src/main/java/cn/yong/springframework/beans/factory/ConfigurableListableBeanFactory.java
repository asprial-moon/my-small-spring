package cn.yong.springframework.beans.factory;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.yong.springframework.beans.factory.config.BeanDefinition;
import cn.yong.springframework.beans.factory.config.BeanPostProcessor;
import cn.yong.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author Line
 * @desc Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * @date 2022/9/11
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 预实例化单例
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

    /**
     * 添加 Bean 后处理器
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
