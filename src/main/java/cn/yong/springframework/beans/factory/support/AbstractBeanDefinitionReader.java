package cn.yong.springframework.beans.factory.support;

import cn.yong.springframework.core.io.DefaultResourceLoader;
import cn.yong.springframework.core.io.ResourceLoader;

/**
 * @author Line
 * @desc 实现BeanDefinitionReader接口的 bean 定义读取器的抽象基类。
 * 提供通用属性，例如要处理的 bean 工厂和用于加载 bean 类的类加载器。
 * @date 2022/9/11
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
