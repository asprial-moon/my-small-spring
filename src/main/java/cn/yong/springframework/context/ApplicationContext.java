package cn.yong.springframework.context;

import cn.yong.springframework.beans.factory.HierarchicalBeanFactory;
import cn.yong.springframework.beans.factory.ListableBeanFactory;
import cn.yong.springframework.core.io.ResourceLoader;

/**
 * @author Line
 * @desc 为应用程序提供配置的中央接口。这在应用程序运行时是只读的，但如果实现支持，则可以重新加载。
 * <p>ApplicationContext 提供：
 * <ul>
 * <li>用于访问应用程序组件的 Bean 工厂方法。继承自ListableBeanFactory 。
 * <li>以通用方式加载文件资源的能力。继承自org.springframework.core.io.ResourceLoader接口。
 * <li>向注册的侦听器发布事件的能力。继承自ApplicationEventPublisher接口。
 * <li>解决消息的能力，支持国际化。继承自MessageSource接口。
 * <li>从父上下文继承。后代上下文中的定义将始终具有优先权。这意味着，例如，整个 Web 应用程序可以使用单个父上下文，而每个 servlet 都有自己的子上下文，该子上下文独立于任何其他 servlet。
 * </ul>
 * <p>除了标准的org.springframework.beans.factory.BeanFactory生命周期功能之外，ApplicationContext 实现检测和调用ApplicationContextAware bean 以及ResourceLoaderAware 、 ApplicationEventPublisherAware和MessageSourceAware bean。
 * @date 2022/9/11
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
