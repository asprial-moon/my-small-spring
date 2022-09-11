package cn.yong.springframework.beans.factory;

/**
 * <p>由BeanFactory中使用的对象实现的接口，这些对象本身就是各个对象的工厂。如果一个 bean 实现了这个接口，它被用作一个对象的工厂来暴露，而不是直接作为一个将自己暴露的 bean 实例。
 * <p>注意：实现此接口的 bean 不能用作普通 bean。 FactoryBean 以 bean 样式定义，但为 bean 引用 ( getObject() ) 公开的对象始终是它创建的对象。
 * @author Line
 * @date 2022/9/11
 */
public interface FactoryBean<T> {
    /**
     * <p>返回此工厂管理的对象的实例（可能是共享的或独立的）。
     * <p>与BeanFactory一样，这允许支持 Singleton 和 Prototype 设计模式。
     * <p>如果在调用时此 FactoryBean 尚未完全初始化（例如，因为它涉及循环引用），则抛出相应的FactoryBeanNotInitializedException 。
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * <p>返回此 FactoryBean 创建的对象的类型，如果事先不知道，则返回null 。
     * <p>这允许人们在不实例化对象的情况下检查特定类型的 bean，例如在自动装配时。
     * <p>在创建单例对象的实现的情况下，此方法应尽量避免创建单例；它应该提前估计类型。对于原型，在这里返回一个有意义的类型也是可取的。
     * <p>可以在此 FactoryBean 完全初始化之前调用此方法。它不能依赖于初始化期间创建的状态；当然，如果可用，它仍然可以使用这种状态。
     * @return
     */
    Class<?> getObjectType();

    /**
     * <p>这个工厂管理的对象是单例吗？也就是说， getObject()是否总是返回相同的对象（可以缓存的引用）？
     * <p>注意：如果 FactoryBean 指示持有一个单例对象，则从getObject()返回的对象可能会被拥有的 BeanFactory 缓存。因此，除非 FactoryBean 始终公开相同的引用，否则不要返回true 。
     * <p>FactoryBean 本身的单例状态一般会由拥有的 BeanFactory 提供；通常，它必须在那里定义为单例
     * @return
     */
    boolean isSingleton();
}
