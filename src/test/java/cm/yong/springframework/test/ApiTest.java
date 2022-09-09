package cm.yong.springframework.test;


import cm.yong.springframework.test.bean.UserDao;
import cm.yong.springframework.test.bean.UserService;
import cn.yong.springframework.PropertyValue;
import cn.yong.springframework.PropertyValues;
import cn.yong.springframework.factory.conifg.BeanDefinition;
import cn.yong.springframework.factory.conifg.BeanReference;
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

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
