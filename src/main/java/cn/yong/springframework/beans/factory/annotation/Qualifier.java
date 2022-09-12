package cn.yong.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author Line
 * @desc
 * @date 2022/9/12
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
