package cn.yong.springframework.beans.factory;


import cn.yong.springframework.beans.BeansException;

/**
 * Bean工厂
 * @author Allen
 * @date 2022/9/9
 */
public interface BeanFactory {

    /**
     * 获取Bean对象
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取Bean对象
     */
    Object getBean(String name, Object...args) throws BeansException;

    /**
     * 获取Bean对象
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    /**
     * 获取Bean对象
     */
    <T> T getBean(Class<T> requiredType) throws BeansException;
}
