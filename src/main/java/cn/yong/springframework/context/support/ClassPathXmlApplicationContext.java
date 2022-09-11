package cn.yong.springframework.context.support;

import cn.yong.springframework.beans.BeansException;

/**
 * <p>独立的 XML 应用程序上下文，从类路径中获取上下文定义文件，将普通路径解释为包含包路径的类路径资源名称（例如“mypackage/myresource.txt”）。对于测试工具以及嵌入在 JAR 中的应用程序上下文很有用。
 *
 * <p>配置位置默认值可以通过getConfigLocations覆盖，配置位置可以表示具体文件，如“/myfiles/context.xml”或 Ant 样式模式，如“/myfiles/*-context.xml”（参见org.springframework.util.AntPathMatcher javadoc 获取模式详细信息）。
 *
 * <p>注意：在多个配置位置的情况下，以后的 bean 定义将覆盖之前加载的文件中定义的那些。这可以用来通过额外的 XML 文件故意覆盖某些 bean 定义。
 *
 * <p>这是一个简单的、一站式便利的ApplicationContext。考虑将GenericApplicationContext类与org.springframework.beans.factory.xml.XmlBeanDefinitionReader结合使用，以获得更灵活的上下文设置。
 * @author Line
 * @desc
 * @date 2022/9/11
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
