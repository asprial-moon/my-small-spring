package cn.yong.springframework.context.event;

import cn.yong.springframework.context.ApplicationEvent;
import cn.yong.springframework.context.ApplicationListener;

/**
 * @author Line
 * @desc 事件广播器
 * @date 2022/9/12
 */
public interface ApplicationEventMulticaster {

    /**
     * Add a listener to be notified of all events.
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
