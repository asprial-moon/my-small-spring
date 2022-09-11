package cn.yong.springframework.test;


import cn.yong.springframework.context.support.ClassPathXmlApplicationContext;
import cn.yong.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author Allen
 * @date 2022/9/9
 */
public class ApiTest {
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);

        // 2. 获取Bean对象调用方法
        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        String result1 = userService1.queryUserInfo();
        System.out.println("测试结果：" + result1 );
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }

}
