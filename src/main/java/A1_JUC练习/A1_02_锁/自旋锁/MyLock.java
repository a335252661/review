package A1_JUC练习.A1_02_锁.自旋锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/22
 */
public class MyLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    Thread thread = new Thread();
    public void addLock() {
        while (!atomicReference.compareAndSet(null , thread)){
        };
        System.out.println(Thread.currentThread().getName()+"线程 加锁");
    }
    public void unLock() {
        atomicReference.compareAndSet(thread , null);
        System.out.println(Thread.currentThread().getName()+"线程 解锁");
    }
    public static void main(String[] args) {
        MyLock demo = new MyLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.addLock();
                try { TimeUnit.SECONDS.sleep(3);  } catch (InterruptedException e) { e.printStackTrace(); }
                demo.unLock();
            }
        },"A").start();
        try { TimeUnit.SECONDS.sleep(1);  } catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.addLock();
                try { TimeUnit.SECONDS.sleep(1);  } catch (InterruptedException e) { e.printStackTrace(); }
                demo.unLock();
            }
        },"B").start();
    }
}
