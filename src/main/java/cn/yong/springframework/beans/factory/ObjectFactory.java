package cn.yong.springframework.beans.factory;

import cn.yong.springframework.beans.BeansException;

/**
 * @author Line
 * @desc 定义一个工厂，它可以在调用时返回一个 Object 实例（可能是共享的或独立的）。
 * @date 2022/9/13
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
