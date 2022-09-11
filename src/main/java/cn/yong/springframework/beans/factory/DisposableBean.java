package cn.yong.springframework.beans.factory;

/**
 * <p>由想要在销毁时释放资源的 bean 实现的接口。 BeanFactory将在作用域 bean 的单独销毁时调用 destroy 方法。一个org.springframework.context.ApplicationContext应该在应用程序生命周期的驱动下在关闭时处理它的所有单例。
 *
 * <p>Spring 管理的 bean 也可以实现 Java 的AutoCloseable接口用于相同的目的。实现接口的另一种方法是指定自定义销毁方法，例如在 XML bean 定义中。有关所有 bean 生命周期方法的列表，请参阅BeanFactory javadocs 。
 * @author Line
 * @date 2022/9/11
 */
public interface DisposableBean {

    /**
     * 在销毁 bean 时由包含BeanFactory调用。
     * @throws Exception
     */
    void destroy() throws Exception;
}
