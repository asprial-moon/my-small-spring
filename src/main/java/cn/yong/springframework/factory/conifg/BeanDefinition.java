package cn.yong.springframework.factory.conifg;

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

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
