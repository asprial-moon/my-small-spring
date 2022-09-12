package cn.yong.springframework.aop;

import java.lang.reflect.Method;

/**
 * 在调用方法之前调用的通知。此类建议不能阻止方法调用继续进行，除非它们抛出 Throwable。
 * @author Line
 * @date 2022/9/12
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    /**
     * 调用给定方法之前的回调。
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    void before(Method method, Object[] args, Object target) throws Throwable;
}
