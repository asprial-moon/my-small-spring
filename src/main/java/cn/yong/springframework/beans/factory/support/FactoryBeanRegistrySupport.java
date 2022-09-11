package cn.yong.springframework.beans.factory.support;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>支持需要处理FactoryBean实例的单例注册表的基类，与DefaultSingletonBeanRegistry的单例管理集成。
 * <p>作为AbstractBeanFactory的基类。
 * @author Line
 * @date 2022/9/11
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    /**
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    /**
     * 从给定的 FactoryBean 中获取要公开的对象（如果以缓存形式存在）。快速检查最小同步
     * @param beanName
     * @return
     */
    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    /**
     * 从给定的 FactoryBean 中获取要公开的对象。
     * @param factoryBean
     * @param beanName
     * @return
     */
    protected Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factoryBean, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != null ? object : NULL_OBJECT);
        } else {
            return doGetObjectFromFactoryBean(factoryBean, beanName);
        }
    }

    /**
     * 从给定的 FactoryBean 中获取要公开的对象。
     * @param factoryBean
     * @param beanName
     * @return
     */
    private Object doGetObjectFromFactoryBean(FactoryBean factoryBean, String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}
