package cn.yong.springframework.beans.factory;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.conifg.AutowireCapableBeanFactory;
import cn.yong.springframework.beans.factory.conifg.BeanDefinition;
import cn.yong.springframework.beans.factory.conifg.ConfigurableBeanFactory;

/**
 * @author Line
 * @desc Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * @date 2022/9/11
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
