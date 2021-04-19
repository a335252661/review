package A1_JUC练习.A1_08_死锁;

import java.util.concurrent.TimeUnit;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/25
 *  死锁肯定是两个以上线程 ， 持有锁，都想获取对方的锁
 */

class MyThread extends  Thread{
    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockA + "\t尝试获得：" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockB + "\t尝试获得：" + lockA);
            }
        }
    }

}

public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new MyThread(lockA,lockB),"Thread-AAA").start();
        new Thread(new MyThread(lockB,lockA),"Thread-BBB").start();

        // jps 查看进程id  18808 DeadLockDemo
        //jstack 18808  查看线程信息
        //Java stack information for the threads listed above:
        //===================================================
        //"Thread-BBB":
        //        at A1_JUC练习.A1_08_死锁.MyThread.run(DeadLockDemo.java:33)
        //        - waiting to lock <0x000000071894f4b0> (a java.lang.String)
        //        - locked <0x000000071894f4e8> (a java.lang.String)
        //        at java.lang.Thread.run(Thread.java:748)
        //"Thread-AAA":
        //        at A1_JUC练习.A1_08_死锁.MyThread.run(DeadLockDemo.java:33)
        //        - waiting to lock <0x000000071894f4e8> (a java.lang.String)
        //        - locked <0x000000071894f4b0> (a java.lang.String)
        //        at java.lang.Thread.run(Thread.java:748)

    }

}
