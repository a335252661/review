package A04_设计模式.A4_04_代理模式.动态代理_cglib;

import A04_设计模式.A4_04_代理模式.静态代理.UserDao;
import org.junit.Test;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/9
 */
public class App {
    public static void main(String[] args) {
        //被代理对象
        MyUser myUser = new MyUser();
        System.out.println(myUser);

        //代理对象
        MyUser proxy = (MyUser)new ProxyFactory(myUser).getProxyInstance();
        System.out.println(proxy);
        //执行代理对象的方法
        proxy.save();
    }
}
