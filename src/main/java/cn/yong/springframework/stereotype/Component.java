package cn.yong.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @author Line
 * @desc
 * @date 2022/9/12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
