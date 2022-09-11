package cn.yong.springframework.context;

import java.util.EventObject;

/**
 * 由所有应用程序事件扩展的类。摘要，因为直接发布通用事件没有意义。
 * @author Line
 * @date 2022/9/12
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
