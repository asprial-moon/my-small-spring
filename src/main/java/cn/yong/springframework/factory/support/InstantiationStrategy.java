package cn.yong.springframework.factory.support;

import cn.yong.springframework.BeansException;
import cn.yong.springframework.factory.conifg.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 负责创建对应于根 bean 定义的实例的接口
 * @author Allen
 * @date 2022/9/9
 */
public interface InstantiationStrategy {

    /**
     * 在此工厂中返回具有给定名称的 bean 实例。
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
