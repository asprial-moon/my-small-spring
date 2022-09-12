package cn.yong.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author Line
 * @desc
 * @date 2022/9/12
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    String value();
}
