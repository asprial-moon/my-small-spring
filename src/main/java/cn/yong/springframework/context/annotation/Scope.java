package cn.yong.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @author Line
 * @desc
 * @date 2022/9/12
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
