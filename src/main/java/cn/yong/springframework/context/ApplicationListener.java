package cn.yong.springframework.context;

import java.util.EventListener;

/**
 * 由应用程序事件监听器实现的接口。基于观察者设计模式的标准 <code>java.util.EventListener<code> 接口。
 * @author Line
 * @date 2022/9/12
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理应用程序事件。
     * @param event
     */
    void onApplicationEvent(E event);
}
