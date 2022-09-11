package cn.yong.springframework.beans.factory.config;

import cn.yong.springframework.beans.BeansException;

/**
 * @author Line
 * @desc 允许自定义修改新 bean 实例的工厂挂钩 - 例如，检查标记接口或使用代理包装 bean。
 * 通常，通过标记接口等填充 bean 的后处理器将实现postProcessBeforeInitialization ，而使用代理包装 bean 的后处理器通常会实现postProcessAfterInitialization 。
 * 登记
 * ApplicationContext可以在其 bean 定义中自动检测BeanPostProcessor bean，并将这些后处理器应用于随后创建的任何 bean。一个普通的BeanFactory允许以编程方式注册后处理器，将它们应用到通过 bean 工厂创建的所有 bean。
 * 订购
 * @date 2022/9/11
 */
public interface BeanPostProcessor {

    /**
     * 在任何 bean 初始化回调（如 InitializingBean 的afterPropertiesSet或自定义 init 方法）之前将此BeanPostProcessor应用于给定的新 bean 实例。 bean 将已填充属性值。返回的 bean 实例可能是原始的包装器。
     * 默认实现按原样返回给定的bean
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在任何 bean 初始化回调（如 InitializingBean 的afterPropertiesSet或自定义 init 方法）之后，将此BeanPostProcessor应用于给定的新 bean 实例。 bean 将已填充属性值。返回的 bean 实例可能是原始的包装器。
     * 在使用 FactoryBean 的情况下，将为 FactoryBean 实例和由 FactoryBean 创建的对象（从 Spring 2.0 开始）调用此回调。后处理器可以通过相应的bean instanceof FactoryBean检查来决定是否应用到 FactoryBean 或创建的对象或两者。
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
