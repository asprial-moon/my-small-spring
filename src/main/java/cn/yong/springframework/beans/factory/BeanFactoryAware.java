package cn.yong.springframework.beans.factory;

import cn.yong.springframework.beans.BeansException;

/**
 * <p>由希望知道自己拥有的BeanFactory的 bean 实现的接口。
 * <p>例如，bean 可以通过工厂（依赖查找）查找协作 bean。请注意，大多数 bean 将选择通过相应的 bean 属性或构造函数参数（依赖注入）接收对协作 bean 的引用
 * @author Line
 * @date 2022/9/11
 */
public interface BeanFactoryAware extends Aware {

    /**
     * 将拥有工厂提供给 bean 实例的回调。
     * @param beanFactory
     * @throws BeansException
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
