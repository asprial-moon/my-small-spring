package cn.yong.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * <p>包含 AOP建议（在连接点采取的操作）和确定建议适用性的过滤器（例如切入点）的基本接口。这个接口不是供 Spring 用户使用的，而是为了支持不同类型的建议的通用性。
 * <p>Spring AOP 基于通过方法拦截提供的建议，符合 AOP 联盟拦截 API。 Advisor 接口允许支持不同类型的建议，例如之前和之后的建议，这些不需要使用拦截来实现。
 * @author Line
 * @date 2022/9/12
 */
public interface Advisor {
    /**
     * 返回此方面的建议部分。一个通知可以是一个拦截器、一个之前的通知、一个抛出的通知等。
     * @return
     */
    Advice getAdvice();
}
