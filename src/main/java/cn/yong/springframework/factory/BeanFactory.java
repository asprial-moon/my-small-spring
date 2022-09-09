package cn.yong.springframework.factory;


import cn.yong.springframework.BeansException;

/**
 * Bean工厂
 * @author Allen
 * @date 2022/9/9
 */
public interface BeanFactory {

    /**
     * 获取Bean对象
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取Bean对象
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object...args) throws BeansException;

}
