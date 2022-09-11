package cn.yong.springframework.beans.factory.support;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.BeanFactory;
import cn.yong.springframework.beans.factory.conifg.BeanDefinition;

/**
 * 抽象类定义模板方法
 * @author Allen
 * @date 2022/9/9
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     * 获取Bean定义
     * @param beanName  bean名称
     * @return  bean定义
     * @throws BeansException Bean异常
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建Bean对象
     * @param beanName bean名称
     * @param beanDefinition bean定义
     * @return  对象
     * @throws BeansException Bean异常
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
