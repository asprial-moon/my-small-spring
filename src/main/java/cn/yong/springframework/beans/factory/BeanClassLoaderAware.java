package cn.yong.springframework.beans.factory;

/**
 * <p>允许 bean 知道 bean class loader的回调；也就是当前bean工厂用来加载bean类的类加载器。
 * <p>这主要是由框架类实现的，这些框架类必须按名称选择应用程序类，尽管它们可能是从共享类加载器加载的
 * @author Line
 * @date 2022/9/11
 */
public interface BeanClassLoaderAware extends Aware {

    /**
     * <p>将 bean class loader提供给 bean 实例的回调。
     * <p>在填充普通 bean 属性之后但在初始化回调之前调用，例如InitializingBean's InitializingBean.afterPropertiesSet()方法或自定义 init 方法。
     * @param classLoader
     */
    void setBeanClassLoader(ClassLoader classLoader);
}
