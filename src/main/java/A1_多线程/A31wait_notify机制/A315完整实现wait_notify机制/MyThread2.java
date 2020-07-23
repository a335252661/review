package A1_多线程.A31wait_notify机制.A315完整实现wait_notify机制;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class MyThread2 extends Thread{
    private Object lock;
    public MyThread2(Object lock) {
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始notify time=" + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束notify time=" + System.currentTimeMillis());
        }
    }
}
