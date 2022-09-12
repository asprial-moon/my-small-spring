package cn.yong.springframework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>基于 JDK dynamic proxies的 Spring AOP 框架的基于 JDK 的AopProxy实现。
 * <p>创建一个动态代理，实现 AopProxy 公开的接口。动态代理不能用于代理类中定义的方法，而不是接口。
 * <p>这种类型的对象应该通过代理工厂获得，由AdvisedSupport类配置。这个类是 Spring 的 AOP 框架内部的，不需要由客户端代码直接使用。
 * <p>如果底层（目标）类是线程安全的，则使用此类创建的代理将是线程安全的。
 * <p>只要所有顾问（包括建议和切入点）和 TargetSource 都是可序列化的，代理就是可序列化的
 * @author Line
 * @date 2022/9/12
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {
    private final AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), advised.getTargetSource().getTargetClass(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
            MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
        }
        return method.invoke(advised.getTargetSource().getTarget(), args);
    }
}
