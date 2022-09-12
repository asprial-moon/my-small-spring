package cn.yong.springframework.aop.framework;

import cn.yong.springframework.aop.AdvisedSupport;

/**
 * 用于编程使用的 AOP 代理工厂，而不是通过 bean 工厂中的声明性设置。此类提供了一种在自定义用户代码中获取和配置 AOP 代理实例的简单方法
 * @author Line
 * @date 2022/9/12
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
