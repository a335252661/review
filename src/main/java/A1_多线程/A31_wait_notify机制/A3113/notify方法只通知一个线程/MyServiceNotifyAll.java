package A1_多线程.A31_wait_notify机制.A3113.notify方法只通知一个线程;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 *
 *
 * 线程全部被唤醒并呈倒序
 * notifyAll唤醒所有线程，谁后wait，那么就先唤醒
 *
 */
public class MyServiceNotifyAll {
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
            lock.notifyAll();
            System.out.println(" end notify " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyServiceNotifyAll service = new MyServiceNotifyAll();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.waitMethod();
                }
            },"T"+i).start();
        }
        Thread.sleep(3000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                service.notifyMethod();
            }
        },"TT").start();
    }

}
