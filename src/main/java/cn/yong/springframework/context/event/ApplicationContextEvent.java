package cn.yong.springframework.context.event;

import cn.yong.springframework.context.ApplicationContext;
import cn.yong.springframework.context.ApplicationEvent;

/**
 * @author Line
 * @desc 为ApplicationContext引发的事件的基类
 * @date 2022/9/12
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * 创建一个新的 ContextStartedEvent
     * @param source
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 获取引发事件的ApplicationContext 。
     * @return
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
