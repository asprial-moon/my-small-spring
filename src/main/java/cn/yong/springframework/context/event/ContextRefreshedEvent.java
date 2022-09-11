package cn.yong.springframework.context.event;

/**
 * @author Line
 * @desc Event raised when an <code>ApplicationContext</code> gets initialized or refreshed.
 * @date 2022/9/12
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
