package A1_多线程.A31_wait_notify机制.A3116wait_long方法自动向下运行需要重新持有锁;

import java.io.IOException;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 *
 * 多个线程被唤醒之后，需要重新获取锁
 */
public class MyService {
    public void testMethod() {
        try {
            synchronized (this) {
                System.out.println("wait begin " +
                        Thread.currentThread().getName() + " "
                        + System.currentTimeMillis());
                wait(5000);
                System.out.println("wait end " +
                        Thread.currentThread().getName() + " "
                        + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void longTimeSyn() {
        try {
            Thread.sleep(10000);
            System.out.println("我是b线程，执行结束，a线程自动苏醒在等待锁才能执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MyService service = new MyService();
        MyThreadA[] array = new MyThreadA[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new MyThreadA(service);
        }
        for (int i = 0; i < 10; i++) {
            array[i].start();
        }
        MyThreadB b = new MyThreadB(service);
        b.start();
    }

}
