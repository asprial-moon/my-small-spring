package cn.yong.springframework.context.event;

import cn.yong.springframework.beans.factory.BeanFactory;
import cn.yong.springframework.context.ApplicationEvent;
import cn.yong.springframework.context.ApplicationListener;

/**
 * @author Line
 * @desc Simple implementation of the {@link ApplicationEventMulticaster} interface.
 * @date 2022/9/12
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
