package cn.yong.springframework.factory.support;

import cn.yong.springframework.BeansException;
import cn.yong.springframework.factory.conifg.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring 的ConfigurableListableBeanFactory和BeanDefinitionRegistry接口的默认实现：一个基于 bean 定义元数据的成熟 bean 工厂，可通过后处理器进行扩展
 * @author Allen
 * @date 2022/9/9
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /**
     * bean 定义对象的映射，以 bean 名称为键。
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }
}
