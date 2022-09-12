package cn.yong.springframework.aop.aspectj;

import cn.yong.springframework.aop.Pointcut;
import cn.yong.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * 可用于任何 AspectJ 切入点表达式的 Spring AOP Advisor。
 * @author Line
 * @date 2022/9/12
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    /**
     * 切面
     */
    private AspectJExpressionPointcut pointcut;
    /**
     * 具体的拦截方法
     */
    private Advice advice;
    /**
     * 表达式
     */
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
