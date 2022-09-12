package cn.yong.springframework.util;

/**
 * @author Line
 * @desc Simple strategy interface for resolving a String value.
 *  * Used by {@link cn.yong.springframework.beans.factory.config.ConfigurableBeanFactory}.
 * @date 2022/9/12
 */
public interface StringValueResolver {

    String resolveStringValue(String strVal);
}
