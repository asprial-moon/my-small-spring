package cn.yong.springframework.context.support;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.yong.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * <p>ApplicationContext实现的基类，它应该支持多次调用refresh() ，每次都创建一个新的内部 bean 工厂实例。通常（但不一定），这样的上下文将由一组配置位置驱动，以从中加载 bean 定义。
 *
 * <p>子类实现的唯一方法是loadBeanDefinitions ，它在每次刷新时被调用。具体实现应该将 bean 定义加载到给定的DefaultListableBeanFactory ，通常委托给一个或多个特定的 bean 定义读取器。
 *
 * <p>请注意，WebApplicationContexts 有一个类似的基类。 org.springframework.web.context.support.AbstractRefreshableWebApplicationContext提供相同的子类化策略，但另外预实现了 Web 环境的所有上下文功能。还有一种预定义的方式来接收 Web 上下文的配置位置。
 *
 * <p>这个基类的具体独立子类，以特定的 bean 定义格式读取，是ClassPathXmlApplicationContext和FileSystemXmlApplicationContext ，它们都派生自通用AbstractXmlApplicationContext基类； org.springframework.context.annotation.AnnotationConfigApplicationContext支持@Configuration -annotated 类作为 bean 定义的来源
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 创建Bean工厂
     * @return
     */
    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载 Bean 定义
     * @param beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
