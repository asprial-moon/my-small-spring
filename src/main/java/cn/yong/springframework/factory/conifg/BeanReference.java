package cn.yong.springframework.factory.conifg;

/**
 * @author Line
 * @desc  bean 名称的引用
 * @date 2022/9/10
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
