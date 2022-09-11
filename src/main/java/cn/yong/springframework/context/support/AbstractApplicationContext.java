package cn.yong.springframework.context.support;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.yong.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.yong.springframework.beans.factory.config.BeanPostProcessor;
import cn.yong.springframework.context.ConfigurableApplicationContext;
import cn.yong.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * ApplicationContext接口的抽象实现。不强制要求用于配置的存储类型；简单地实现通用的上下文功能。使用模板方法设计模式，需要具体的子类来实现抽象方法。
 *
 * <p> 与普通的 BeanFactory 相比，ApplicationContext 应该检测其内部 bean 工厂中定义的特殊 bean：因此，此类自动注册BeanFactoryPostProcessors 、 BeanPostProcessors和ApplicationListeners ，它们在上下文中定义为 bean。
 *
 * <p> MessageSource也可以作为上下文中的 bean 提供，名称为“messageSource”；否则，消息解析将委托给父上下文。此外，应用程序事件的多播器可以在上下文中作为ApplicationEventMulticaster类型的“applicationEventMulticaster”bean 提供；否则，将使用SimpleApplicationEventMulticaster类型的默认多播器。
 *
 * <p> 通过扩展DefaultResourceLoader实现资源加载。因此，将非 URL 资源路径视为类路径资源（支持包含包路径的完整类路径资源名称，例如“mypackage/myresource.dat”），除非在子类中覆盖getResourceByPath方法
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1.创建BeanFactory,并加载 BeanDefinition
        refreshBeanFactory();

        // 2.获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4.BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 5.提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    /**
     * 创建BeanFactory,并加载 BeanDefinition
     * @throws BeansException
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 获取BeanFactory
     * @return
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 调用 Bean Factory 后处理器
     * @param beanFactory
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
