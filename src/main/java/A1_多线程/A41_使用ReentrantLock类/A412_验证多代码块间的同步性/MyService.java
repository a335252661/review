package A1_多线程.A41_使用ReentrantLock类.A412_验证多代码块间的同步性;

import Helps.ListHelp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/27
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    public void methodA() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA end ThreadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void methodB() {
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end ThreadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        MyService service = new MyService();
        ListHelp.fast(3).forEach(i -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.methodA();
                }
            },"T"+i).start();
        });

        Thread.sleep(100);

        ListHelp.fast(3).forEach(i -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.methodB();
                }
            },"TB"+i).start();
        });




    }



}
