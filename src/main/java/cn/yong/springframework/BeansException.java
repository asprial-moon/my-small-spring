package cn.yong.springframework;

/**
 * bean 包和子包中抛出的所有异常的抽象超类
 * @author Allen
 * @date 2022/9/9
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
