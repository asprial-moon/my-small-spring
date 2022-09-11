package cn.yong.springframework.context;

import cn.yong.springframework.beans.BeansException;

/**
 * @author Line
 * @desc 大多数（如果不是所有）应用程序上下文都将实现 SPI 接口。除了ApplicationContext接口中的应用程序上下文客户端方法之外，还提供了配置应用程序上下文的工具。
 * 配置和生命周期方法被封装在这里，以避免使它们对 ApplicationContext 客户端代码显而易见。本方法只应由启动和关闭代码使用。
 * @date 2022/9/11
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册钩子
     */
    void registerShutdownHook();

    /**
     * 关闭
     */
    void close();
}
