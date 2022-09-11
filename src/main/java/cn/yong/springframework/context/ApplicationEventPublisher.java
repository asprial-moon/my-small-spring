package cn.yong.springframework.context;

/**
 * @author Line
 * @desc 封装事件发布功能的接口。作为 ApplicationContext 的超级接口
 * @date 2022/9/12
 */
public interface ApplicationEventPublisher {

    /**
     * 通知所有使用此应用程序注册的侦听器应用程序事件。事件可以是框架事件（例如 RequestHandledEvent）或特定于应用程序的事件
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
