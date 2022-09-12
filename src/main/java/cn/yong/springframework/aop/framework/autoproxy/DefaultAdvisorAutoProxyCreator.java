package cn.yong.springframework.aop.framework.autoproxy;

import cn.yong.springframework.aop.*;
import cn.yong.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.yong.springframework.aop.framework.ProxyFactory;
import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.PropertyValues;
import cn.yong.springframework.beans.factory.BeanFactory;
import cn.yong.springframework.beans.factory.BeanFactoryAware;
import cn.yong.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.yong.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * <p>BeanPostProcessor实现基于当前BeanFactory中的所有候选Advisor创建 AOP 代理。这个类是完全通用的；它不包含处理任何特定方面的特殊代码，例如池方面。
 * <p>可以过滤掉顾问——例如，在同一个工厂中使用多个这种类型的后处理器——通过将usePrefix属性设置为 true，在这种情况下，只有以 DefaultAdvisorAutoProxyCreator 的 bean 名称后跟一个点开头的顾问（如“aapc 。“） 将会被使用。通过设置advisorBeanNamePrefix属性，可以从 bean 名称更改此默认前缀。在这种情况下也将使用分隔符 (.)
 *
 * @author Line
 * @date 2022/9/12
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (isInfrastructureClass(bean.getClass())) {
            return bean;
        }

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(bean.getClass())) {
                continue;
            }
            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(bean);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);

            return new ProxyFactory(advisedSupport).getProxy();
        }
        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }
}
