package cm.yong.springframework.test.bean;

/**
 * @author Allen
 * @date 2022/9/9
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息, 用户名称：" + name);
    }
}
