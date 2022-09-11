package cn.yong.springframework.beans.factory.support;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.conifg.BeanDefinition;

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

    /**
     * 使用Bean名称查询BeanDefinition
     * @param beanName bean实例名称
     * @return  bean定义
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName bean实例名称
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
