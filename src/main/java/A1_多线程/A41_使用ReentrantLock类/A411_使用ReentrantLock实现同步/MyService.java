package A1_多线程.A41_使用ReentrantLock类.A411_使用ReentrantLock实现同步;

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
    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + (" " + (i + 1)));
        }
        lock.unlock();
    }

    public static void main(String[] args) {

        MyService myService = new MyService();

        for(int i=0 ;i<5 ; i++ ){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myService.testMethod();
                }
            },"T"+i).start();
        }
    }

}
