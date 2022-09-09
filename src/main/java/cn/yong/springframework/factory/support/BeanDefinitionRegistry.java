package cn.yong.springframework.factory.support;

import cn.yong.springframework.factory.conifg.BeanDefinition;

/**
 * bean 定义的注册表的接口
 * @author Allen
 * @date 2022/9/9
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册
     * @param beanName 要注册的 bean 实例的名称
     * @param beanDefinition 要注册的 bean 实例的定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
