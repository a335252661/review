package A1_多线程.A21_synchronized同步方法.可重入锁;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 *
 * “可重入锁“是指自己可以再次获取自己的内部
 * 锁。例如，一个线程获得了某个对象锁，此时这个
 * 对象锁还没有释放，当其再次想要获取这个对象锁
 * 时还是可以获取的，如果不可重入锁，则方法
 * service2()不会被调用，方法service3()更不会被调
 * 用。
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
