package A1_多线程.A21_synchronized同步方法.demo3_1;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 *
 * methodA   是同步方法
 * 通过上面的示例可以得知，虽然线程A先持有了
 * object对象的锁，但线程B完全可以异步调用非
 * synchronized类型的方法。
 */
public class MyObject {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName="
                    + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end endTime=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void methodB() {
        try {
            System.out.println("begin methodB threadName="
                    + Thread.currentThread().getName() + " begin time="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //a线程调用a方法   b线程调用b方法
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");
        ThreadB b = new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}
