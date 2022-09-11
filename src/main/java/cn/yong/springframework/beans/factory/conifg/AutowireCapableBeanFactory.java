package cn.yong.springframework.beans.factory.conifg;

import cn.yong.springframework.beans.factory.BeanFactory;

/**
 * @author Line
 * @desc Extension of the {@link cn.yong.springframework.beans.factory.BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 * @date 2022/9/11
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
}
