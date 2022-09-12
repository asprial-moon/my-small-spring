package cn.yong.springframework.beans.factory.config;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.PropertyValues;

/**
 * <p>添加实例化前回调的BeanPostProcessor子接口，以及实例化后但在设置显式属性或发生自动装配之前的回调。
 * <p>通常用于抑制特定目标 bean 的默认实例化，例如创建具有特殊 TargetSources 的代理（池目标、延迟初始化目标等），或实现其他注入策略，如字段注入。
 * @author Line
 * @date 2022/9/12
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * <p>在目标 bean 被实例化之前应用这个 BeanPostProcessor。返回的 bean 对象可能是要使用的代理而不是目标 bean，从而有效地抑制了目标 bean 的默认实例化。
     * <p>如果这个方法返回了一个非空的对象，那么bean的创建过程就会短路。唯一应用的进一步处理是来自配置的BeanPostProcessors的postProcessAfterInitialization回调。
     * <p>此回调将应用于 bean 定义及其 bean 类，以及工厂方法定义，在这种情况下，返回的 bean 类型将在此处传递。
     * <p>后处理器可以实现扩展的SmartInstantiationAwareBeanPostProcessor接口，以预测它们将在此处返回的 bean 对象的类型。
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * Perform operations after the bean has been instantiated, via a constructor or factory method,
     * but before Spring property population (from explicit properties or autowiring) occurs.
     * <p>This is the ideal callback for performing field injection on the given bean instance.
     * See Spring's own {@link cn.yong.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}
     * for a typical example.
     * <p>
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * Post-process the given property values before the factory applies them
     * to the given bean. Allows for checking whether all dependencies have been
     * satisfied, for example based on a "Required" annotation on bean property setters.
     *
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;
}
