package cn.yong.springframework.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.PropertyValues;
import cn.yong.springframework.beans.factory.BeanFactory;
import cn.yong.springframework.beans.factory.BeanFactoryAware;
import cn.yong.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.yong.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.yong.springframework.util.ClassUtils;

import java.lang.reflect.Field;

/**
 * <p>自动装配带注释的字段、设置方法和任意配置方法的BeanPostProcessor实现。此类要注入的成员是通过注解检测的：默认情况下，Spring 的@Autowired和@Value注解。
 *
 * <p>还支持 JSR-330 的@Inject注释（如果可用）作为 Spring 自己的@Autowired的直接替代品。
 * <h3>自动装配的构造函数
 *
 * <p>任何给定 bean 类中只有一个构造函数可以声明此注释，并将 'required' 属性设置为true ，指示构造函数在用作 Spring bean 时自动装配。此外，如果 'required' 属性设置为true ，则只能使用@Autowired注释单个构造函数。如果多个非必需的构造函数声明了注解，它们将被视为自动装配的候选者。将选择在 Spring 容器中通过匹配 bean 可以满足的依赖项数量最多的构造函数。如果不能满足任何候选者，则将使用主/默认构造函数（如果存在）。如果一个类只声明了一个构造函数，即使没有注释，它也会一直被使用。带注释的构造函数不必是公共的。
 * <h3>自动连线字段
 *
 * <p>在构造 bean 之后，在调用任何配置方法之前，立即注入字段。这样的配置字段不必是公开的。
 * <h3>自动装配方法
 *
 * <p>配置方法可以有任意名称和任意数量的参数；这些参数中的每一个都将与 Spring 容器中的匹配 bean 自动装配。 Bean 属性设置方法实际上只是这种通用配置方法的一个特例。配置方法不必是公开的。
 * <h3>注释配置与 XML 配置
 * 默认的AutowiredAnnotationBeanPostProcessor将由“context:annotation-config”和“context:component-scan”XML 标签注册。如果您打算指定自定义AutowiredAnnotationBeanPostProcessor bean 定义，请删除或关闭默认注释配置。
 * 注意：注解注入将在 XML 注入之前进行；因此，对于通过这两种方法连接的属性，后一种配置将覆盖前者。
 * @查找方法
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 1.处理注解 @Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (null != valueAnnotation) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 2.处理注解 @Autowired
        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (null != autowiredAnnotation) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if (null != qualifierAnnotation) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean =  beanFactory.getBean(dependentBeanName);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }
}
