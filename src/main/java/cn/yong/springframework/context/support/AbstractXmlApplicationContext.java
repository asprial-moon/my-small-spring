package cn.yong.springframework.context.support;

import cn.yong.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.yong.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * ApplicationContext实现的方便基类，从包含由XmlBeanDefinitionReader理解的 bean 定义的 XML 文档中绘制配置。
 *
 * <p>子类只需要实现getConfigResources和/或getConfigLocations方法。此外，它们可能会覆盖getResourceByPath挂钩以以特定于环境的方式解释相对路径，和/或getResourcePatternResolver以扩展模式解析。
 * @author Line
 * @date 2022/9/11
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
