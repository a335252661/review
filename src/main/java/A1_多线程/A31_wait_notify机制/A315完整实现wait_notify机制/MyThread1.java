package A1_多线程.A31_wait_notify机制.A315完整实现wait_notify机制;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class MyThread1 extends Thread{
    private Object lock;
    public MyThread1(Object lock) {
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始 wait time=" +
                        System.currentTimeMillis());
                lock.wait();
                System.out.println("结束 wait time=" +
                        System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
