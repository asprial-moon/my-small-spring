package cn.yong.springframework.context.event;

/**
 * @Desc
 * @Author Line
 * @Date 2022/9/12
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * 创建一个新的 ContextClosedEvent。
     *
     * @param source
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
