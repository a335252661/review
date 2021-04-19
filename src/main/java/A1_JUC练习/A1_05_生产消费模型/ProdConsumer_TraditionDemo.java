package A1_JUC练习.A1_05_生产消费模型;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/24
 *
 * 一个初始值为0的变量，两个线程交替执行，一个加1一个减1，来五轮
 * 线程   操作（方法）  资源类  ,这样我的资源类是高内聚的
 * 判断（判断谁来操作）   干活  通知
 * 防止虚假唤醒
 * 举例：两个人对空调操作，一个人对空调加一度，一个人对空调减一度，空调就是我们的额资源类，加一度，减一度方法肯定是空调自带的，两个人调用这个方法
 * 两个人争抢，必然要加锁 ， 锁也放在资源类
 */

class ShareData{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition  = lock.newCondition();

    public void increment(){
        lock.lock();
//        nonfairTryAcquire
        try {
            while (number != 0){
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+" :" + number);
            //通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement(){
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+" :" + number);
            //通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.increment();
            }
        } , "线程A").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.decrement();
            }
        } , "线程B").start();


    }
}
