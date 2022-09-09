package cm.yong.springframework.test;


import cm.yong.springframework.test.bean.UserService;
import cn.yong.springframework.factory.conifg.BeanDefinition;
import cn.yong.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author Allen
 * @date 2022/9/9
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
        userService.queryUserInfo();
    }

}
