package A04_设计模式.A4_04_代理模式.静态代理;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/9
 *
 * 静态代理：
 * 用户想调用方法 ，叫别人帮忙调用，把自己信息给代理对象
 * 缺点：代理对象需要拥有和被代理对象一样的方法
 */
public class App {
    public static void main(String[] args) {
        //用户
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        proxy.save();//执行的是代理的方法
    }
}
