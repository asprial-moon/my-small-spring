package cn.yong.springframework.beans.factory.config;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author Line
 * @desc 工厂挂钩，允许自定义修改应用程序上下文的 bean 定义，调整上下文底层 bean 工厂的 bean 属性值。
 * 对于针对覆盖应用程序上下文中配置的 bean 属性的系统管理员的自定义配置文件很有用。有关满足此类配置需求的开箱即用解决方案，请参阅PropertyResourceConfigurer及其具体实现。
 * BeanFactoryPostProcessor可以与 bean 定义交互和修改，但不能与 bean 实例交互。这样做可能会导致过早的 bean 实例化，违反容器并导致意外的副作用。如果需要 bean 实例交互，请考虑实现BeanPostProcessor 。
 * 登记
 * @date 2022/9/11
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在标准初始化之后修改应用程序上下文的内部 bean 工厂。所有 bean 定义都将被加载，但还没有 bean 被实例化。
     * 这允许覆盖或添加属性，甚至是急切初始化的 bean。
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
