package cn.yong.springframework.beans.factory.support;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.core.io.Resource;
import cn.yong.springframework.core.io.ResourceLoader;

/**
 * @author Line
 * @desc bean 定义阅读器的简单接口，它使用Resource和String位置参数指定加载方法。
 * @date 2022/9/11
 */
public interface BeanDefinitionReader {

    /**
     * bean 定义的注册表
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载 Bean 定义
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 加载 Bean 定义
     * @param resources
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource...resources) throws BeansException;

    /**
     * 加载 Bean 定义
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 加载 Bean 定义
     * @param locations
     * @throws BeansException
     */
    void loadBeanDefinitions(String...locations) throws BeansException;
}
