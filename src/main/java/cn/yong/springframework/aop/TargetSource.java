package cn.yong.springframework.aop;

import cn.yong.springframework.util.ClassUtils;

/**
 * <p>targetSource用于获取 AOP 调用的当前“目标”，如果没有环绕通知选择结束拦截器链本身，则将通过反射调用该目标。
 * <p>如果TargetSource是“静态的”，它将始终返回相同的目标，从而允许在 AOP 框架中进行优化。动态目标源可以支持池化、热交换等。
 * @author Line
 * @date 2022/9/12
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * <p>返回此TargetSource返回的目标类型。
     * <p>可以返回null ，尽管TargetSource的某些用法可能只适用于预定的目标类。
     * @return
     */
    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    /**
     * 返回一个目标实例。在 AOP 框架调用 AOP 方法调用的“目标”之前立即调用。
     * @return
     */
    public Object getTarget() {
        return this.target;
    }
}
