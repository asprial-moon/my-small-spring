package cn.yong.springframework.test.bean;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.BeanClassLoaderAware;
import cn.yong.springframework.beans.factory.BeanFactory;
import cn.yong.springframework.beans.factory.BeanFactoryAware;
import cn.yong.springframework.beans.factory.BeanNameAware;
import cn.yong.springframework.context.ApplicationContext;
import cn.yong.springframework.context.ApplicationContextAware;

/**
 * @author Allen
 * @date 2022/9/9
 */
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
        System.out.println("===1===");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("===2===");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
        System.out.println("===3===");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("===4===");
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
