package cn.yong.springframework.aop;

import java.lang.reflect.Method;

/**
 * <p>Pointcut的一部分：检查目标方法是否有资格获得建议。
 * <p>MethodMatcher 可以静态评估或在运行时（动态）评估。静态匹配涉及方法和（可能）方法属性。动态匹配还使特定调用的参数可用，并且运行先前建议的任何效果都适用于连接点。
 * <p>如果实现从其isRuntime()方法返回false ，则可以静态执行评估，并且对于此方法的所有调用，无论其参数如何，结果都是相同的。这意味着如果isRuntime()方法返回false ，则永远不会调用 3-arg matches(Method, Class, Object[])方法。
 * <p>如果一个实现从其 2-arg matches(Method, Class)方法返回true并且其isRuntime()方法返回true ，则 3-arg matches(Method, Class, Object[])方法将在每次可能执行之前立即调用相关的advice ，决定advice是否应该运行。所有先前的通知，例如拦截器链中的早期拦截器，都将运行，因此它们在参数或 ThreadLocal 状态中产生的任何状态更改都将在评估时可用。
 * <p>这个接口的具体实现通常应该提供Object.equals(Object)和Object.hashCode()的正确实现，以便允许在缓存场景中使用匹配器——例如，在由 CGLIB 生成的代理中。
 * @author Line
 * @date 2022/9/12
 */
public interface MethodMatcher {
    /**
     * <p>执行静态检查给定方法是否匹配。
     * <p>如果这返回false或isRuntime()方法返回false ，则不会进行运行时检查（即没有matches(Method, Class, Object[])调用）。
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method, Class<?> targetClass);
}
