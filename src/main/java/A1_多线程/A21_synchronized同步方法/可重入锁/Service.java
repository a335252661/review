package A1_多线程.A21_synchronized同步方法.可重入锁;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class Service {
    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }
    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }
    synchronized public void service3() {
        System.out.println("service3");
    }

    public static void main(String[] args) {
        Service service = new Service();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.service1();
            }
        },"A").start();
    }
}
