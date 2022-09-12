package cn.yong.springframework.aop;

/**
 * <p>核心 Spring 切入点抽象。
 * <p>切入点由ClassFilter和MethodMatcher 。这些基本术语和切入点本身都可以组合起来建立组合（例如通过org.springframework.aop.support.ComposablePointcut ）。
 * @author Line
 * @date 2022/9/12
 */
public interface Pointcut {

    /**
     * 返回此切入点的 ClassFilter。
     * @return
     */
    ClassFilter getClassFilter();

    /**
     * 返回此切入点的 MethodMatcher。
     * @return
     */
    MethodMatcher getMethodMatcher();
}
