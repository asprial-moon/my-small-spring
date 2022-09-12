package cn.yong.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * <p>AOP 代理配置管理器的基类。这些本身不是 AOP 代理，但此类的子类通常是工厂，从中可以直接获取 AOP 代理实例。
 * <p>此类释放了 Advices 和 Advisors 的内务管理的子类，但实际上并没有实现由子类提供的代理创建方法。
 * <p>这个类是可序列化的；子类不需要。此类用于保存代理的快照。
 * @author Line
 * @date 2022/9/12
 */
public class AdvisedSupport {
    /**
     * proxyConfig
     */
    private boolean proxyTargetClass = false;
    /**
     * 被代理的目标对象
     */
    private TargetSource targetSource;
    /**
     * 方法拦截器
     */
    private MethodInterceptor methodInterceptor;
    /**
     * 方法匹配器(检查目标方法是否符合通知条件)
     */
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }

    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

}
