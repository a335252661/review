package A1_多线程.A31_wait_notify机制.A3113.notify方法只通知一个线程;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 *
 * notify()方法仅按照执行wait()方法的顺序依次唤
 * 醒一个线程,谁先wait，那么谁就会被先唤醒
 */
public class MyService {
    private Object lock = new Object();
    public void waitMethod() {
        try {
            synchronized (lock) {
                System.out.println("begin wait " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
                lock.wait();
                System.out.println(" end wait " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void notifyMethod() {
        synchronized (lock) {
            System.out.println("begin notify " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
            lock.notify();
            System.out.println(" end notify " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        for (int i = 0; i < 10; i++) {
            MyThreadA t1 = new MyThreadA(service);
            t1.start();
        }
        Thread.sleep(3000);
        MyThreadB t1 = new MyThreadB(service);
        t1.start();
        Thread.sleep(500);
        MyThreadB t2 = new MyThreadB(service);
        t2.start();
        Thread.sleep(500);
        MyThreadB t3 = new MyThreadB(service);
        t3.start();
        Thread.sleep(500);
        MyThreadB t4 = new MyThreadB(service);
        t4.start();
        Thread.sleep(500);
        MyThreadB t5 = new MyThreadB(service);
        t5.start();
// 一共唤醒5个线程
    }

}
