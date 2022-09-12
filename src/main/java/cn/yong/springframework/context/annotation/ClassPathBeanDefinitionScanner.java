package cn.yong.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import cn.yong.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import cn.yong.springframework.beans.factory.config.BeanDefinition;
import cn.yong.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.yong.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author Line
 * @desc 一个 bean 定义扫描器，用于检测类路径上的 bean 候选，向给定的注册表（{@code BeanFactory} 或 {@code ApplicationContext}）注册相应的 bean 定义。
 * @date 2022/9/12
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String...basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析 Bean 的作用域 singleton、prototype
                String beanScope = resolveBeanScan(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
        // 注册处理注解的 BeanPostProcessor（@Autowired、@Value）
        registry.registerBeanDefinition("cn.yong.springframework.context.annotation.internalAutowiredAnnotationProcessor", new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));
    }

    private String resolveBeanScan(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) {
            return scope.value();
        }
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
}
