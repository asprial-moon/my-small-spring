package cn.yong.springframework.aop.framework;

/**
 * <p>已配置 AOP 代理的委托接口，允许创建实际的代理对象。
 * <p>开箱即用的实现可用于 JDK 动态代理和 CGLIB 代理，由DefaultAopProxyFactory应用
 * @author Line
 * @date 2022/9/12
 */
public interface AopProxy {
    /**
     * <p>创建一个新的代理对象。
     * <p>使用 AopProxy 的默认类加载器（如果需要创建代理）：通常是线程上下文类加载器。
     * @return
     */
    Object getProxy();
}
