package cn.yong.springframework.beans.factory.config;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.BeanFactory;

/**
 * @author Line
 * @desc Extension of the {@link cn.yong.springframework.beans.factory.BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 * @date 2022/9/11
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 将BeanPostProcessors应用于给定的现有 bean 实例，调用它们的postProcessBeforeInitialization方法。返回的 bean 实例可能是原始的包装器。
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 将BeanPostProcessors应用于给定的现有 bean 实例，调用它们的postProcessAfterInitialization方法。返回的 bean 实例可能是原始的包装器
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
