package cn.yong.springframework.beans.factory.config;

/**
 * 单例注册接口
 * @author Allen
 * @date 2022/9/9
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例接口
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * <p>在给定的 bean 名称下，在 bean 注册表中将给定的现有对象注册为单例。
     * <p>给定的实例应该被完全初始化；注册表不会执行任何初始化回调（特别是，它不会调用 InitializingBean 的afterPropertiesSet方法）。给定的实例也不会收到任何销毁回调（如 DisposableBean 的destroy方法）。
     * <p>在完整的 BeanFactory 中运行时：如果您的 bean 应该接收初始化和/或销毁回调，则注册一个 bean 定义而不是现有实例。
     * <p>通常在注册表配置期间调用，但也可用于单例的运行时注册。因此，注册表实现应该同步单例访问；如果它支持 BeanFactory 的单例延迟初始化，它无论如何都必须这样做。
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);
}
