package cn.yong.springframework.test.common;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.PropertyValue;
import cn.yong.springframework.beans.PropertyValues;
import cn.yong.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.yong.springframework.beans.factory.config.BeanDefinition;
import cn.yong.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
