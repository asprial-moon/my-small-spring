package cn.yong.springframework.beans.factory;

/**
 * 由BeanFactory设置所有属性后需要做出反应的 bean 实现的接口：例如执行自定义初始化，或仅检查所有强制属性是否已设置。
 *
 * <p>实现InitializingBean的另一种方法是指定自定义 init 方法，例如在 XML bean 定义中。有关所有 bean 生命周期方法的列表，请参阅BeanFactory javadocs 。
 *
 * @author Line
 * @date 2022/9/11
 */
public interface InitializingBean {

    /**
     * 在设置所有 bean 属性并满足BeanFactoryAware 、 ApplicationContextAware等后由包含BeanFactory调用。
     *
     * <p>此方法允许 bean 实例在设置所有 bean 属性后执行其整体配置和最终初始化的验证
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
