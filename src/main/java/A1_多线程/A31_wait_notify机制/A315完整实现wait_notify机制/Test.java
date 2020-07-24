package A1_多线程.A31_wait_notify机制.A315完整实现wait_notify机制;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class Test {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            MyThread1 t1 = new MyThread1(lock);
            t1.start();
            Thread.sleep(3000);
            MyThread2 t2 = new MyThread2(lock);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
