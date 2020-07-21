package A1_多线程.A21synchronized同步方法.demo1;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 * 方法中的变量不存在非线程安全问题，永远都
 * 是线程安全的，这是因为方法内部的变量具有私有
 * 特性。
 *
 * mun2 为实例变量  单例模式中的实例变量呈非线程安全状态
 */
public class HasSelfPrivateNum {

    private int mun2 = 0;

//    public  void addI(String username) {
    synchronized public void addI(String username) {   //加锁 变成线程安全
        try {
            int num = 0;
            if (username.equals("a")) {
                num = 100;
                mun2 = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                mun2 = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num  + " ==========mun2=" + mun2);
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
