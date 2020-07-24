package A1_多线程.A23_volatile关键字.A232非原子性的测试;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 *
 * 除了在i++操作时使用synchronized关键字实现同
 * 步外，还可以使用AtomicInteger原子类实现原子性。
 * 原子操作是不能分割的整体，没有其他线程能
 * 够中断或检查处于原子操作中的变量。一个原子
 * （atomic）类型就是一个原子操作可用的类型，它可
 * 以在没有锁（lock）的情况下做到线程安全
 */
public class A2AddCountThread extends Thread{
    private AtomicInteger count = new AtomicInteger(0);
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(count.incrementAndGet());
        }
    }

    public static void main(String[] args) {
        A2AddCountThread countService = new A2AddCountThread();
        Thread t1 = new Thread(countService);
        t1.start();
        Thread t2 = new Thread(countService);
        t2.start();
        Thread t3 = new Thread(countService);
        t3.start();
        Thread t4 = new Thread(countService);
        t4.start();
        Thread t5 = new Thread(countService);
        t5.start();
    }
}
