package cn.yong.springframework.aop.aspectj;

import cn.yong.springframework.aop.ClassFilter;
import cn.yong.springframework.aop.MethodMatcher;
import cn.yong.springframework.aop.Pointcut;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Spring org.springframework.aop.Pointcut实现，它使用 AspectJ 编织器来评估切入点表达式。
 * <p>切入点表达式值是一个 AspectJ 表达式。这可以引用其他切入点并使用组合和其他操作。
 * <p>当然，由于这是由 Spring AOP 的基于代理的模型处理的，因此只支持方法执行切入点。
 * @author Line
 * @date 2022/9/12
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {
    private static final Set<PointcutPrimitive> SUPPORTED_PRIMITIVES = new HashSet<>();

    static {
        SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }

    private final PointcutExpression pointcutExpression;

    public AspectJExpressionPointcut(String expression) {
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORTED_PRIMITIVES, this.getClass().getClassLoader());
        this.pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }

    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
