package cn.yong.springframework.beans.factory.support;

import cn.yong.springframework.beans.factory.conifg.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例注册接口定义和实现
 *
 * @author Allen
 * @Date 2022/9/9
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 单例池
     */
    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
