package cn.yong.springframework.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * <p>Spring对AOP联盟MethodInvocation接口的实现，实现了扩展的ProxyMethodInvocation接口。
 * <p>使用反射调用目标对象。子类可以重写invokeJoinpoint()方法来改变这种行为，所以这对于更专业的 MethodInvocation 实现来说也是一个有用的基类。
 * <p>可以使用invocableClone()方法克隆一个调用，重复调用proceed() （每个克隆一次）。也可以使用setUserAttribute / getUserAttribute方法将自定义属性附加到调用。
 * <p>注意：此类被认为是内部的，不应直接访问。它公开的唯一原因是与现有框架集成（例如 Pitchfork）的兼容性。对于任何其他目的，请改用ProxyMethodInvocation接口
 * @author Line
 * @date 2022/9/12
 */
public class ReflectiveMethodInvocation  implements MethodInvocation {
    protected final Object target;
    protected final Method method;
    protected final Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
