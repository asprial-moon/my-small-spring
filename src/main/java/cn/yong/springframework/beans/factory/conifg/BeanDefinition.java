package cn.yong.springframework.beans.factory.conifg;

import cn.yong.springframework.beans.PropertyValues;

/**
 * @Desc Bean定义
 * @author Allen
 * @date 2022/9/9
 */
public class BeanDefinition {

    /**
     * bean classType
     */
    private Class beanClass;

    /**
     * 属性值列表
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this(beanClass, new PropertyValues());
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
