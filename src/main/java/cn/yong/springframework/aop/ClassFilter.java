package cn.yong.springframework.aop;

/**
 * <p>限制切入点匹配或对给定目标类的介绍的过滤器。
 * <p>可用作Pointcut的一部分或用于IntroductionAdvisor的整个定位。
 * <p>这个接口的具体实现通常应该提供Object.equals(Object)和Object.hashCode()的正确实现，以便允许在缓存场景中使用过滤器——例如，在 CGLIB 生成的代理中。
 * @author Line
 * @date 2022/9/12
 */
public interface ClassFilter {

    /**
     * 切入点是否应该应用于给定的接口或目标类？
     * @param clazz
     * @return
     */
    boolean matches(Class<?> clazz);
}
