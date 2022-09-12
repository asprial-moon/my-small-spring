package cn.yong.springframework.beans.factory;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.PropertyValue;
import cn.yong.springframework.beans.PropertyValues;
import cn.yong.springframework.beans.factory.config.BeanDefinition;
import cn.yong.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.yong.springframework.core.io.DefaultResourceLoader;
import cn.yong.springframework.core.io.Resource;
import cn.yong.springframework.util.StringValueResolver;

import java.util.Properties;

/**
 * <p>PlaceholderConfigurerSupport子类，它根据local properties和/或系统属性和环境变量解析 ${...} 占位符。
 * <p>PropertyPlaceholderConfigurer仍然适合在以下情况下使用：
 * <ul>
 * <li>spring-context模块不可用（即，一个使用 Spring 的BeanFactory API 而不是ApplicationContext ）。
 * <li>现有配置使用"systemPropertiesMode"和/或"systemPropertiesModeName"属性。鼓励用户不要使用这些设置，而是通过容器的Environment配置属性源搜索顺序；但是，可以通过继续使用PropertyPlaceholderConfigurer来保持功能的精确保存。
 * </ul>
 * @author Line
 * @date 2022/9/12
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    /**
     * Default placeholder prefix: {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
    /**
     * Default placeholder suffix: {@value}
     */
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";
    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) {
                        continue;
                    }
                    value = resolvePlaceholder((String) value, properties);
                    propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), value));
                }
            }
            // 向容器中添加字符串解析器，供解析@Value注解使用
            PlaceholderResolvingStringValueResolver valueResolver = new PlaceholderResolvingStringValueResolver(properties);
            beanFactory.addEmbeddedValueResolver(valueResolver);
        } catch (Exception e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    private String resolvePlaceholder(String value, Properties properties) {
        String strVal = value;
        StringBuilder buffer = new StringBuilder(strVal);
        int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
        int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
        if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
            String propKey = strVal.substring(startIdx + 2, stopIdx);
            String propVal = properties.getProperty(propKey);
            buffer.replace(startIdx, stopIdx + 1, propVal);
        }
        return buffer.toString();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private class PlaceholderResolvingStringValueResolver implements StringValueResolver {
        private final Properties properties;
        public PlaceholderResolvingStringValueResolver(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String resolveStringValue(String strVal) {
            return PropertyPlaceholderConfigurer.this.resolvePlaceholder(strVal, properties);
        }
    }
}
