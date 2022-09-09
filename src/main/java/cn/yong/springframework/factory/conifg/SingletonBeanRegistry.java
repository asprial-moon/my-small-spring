package cn.yong.springframework.factory.conifg;

/**
 * 单例注册接口
 * @author Allen
 * @date 2022/9/9
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例接口
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

}
