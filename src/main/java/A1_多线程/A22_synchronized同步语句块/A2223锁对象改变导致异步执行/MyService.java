package A1_多线程.A22_synchronized同步语句块.A2223锁对象改变导致异步执行;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 *
 * 在将任何数据类型作为同步锁时，需要注意是
 * 否有多个线程同时争抢锁对象。如果多个线程同时
 * 争抢相同的锁对象，则这些线程之间就是同步的；
 * 如果多个线程分别获得自己的锁，则这些线程之间
 * 就是异步的。
 * 通常情况下，一旦持有锁后就不再对锁对象进
 * 行更改，因为一旦更改就有可能出现一些错误。
 *
 * 同步代码块任意锁一般固定后不可修改
 */
public class MyService {
    private String lock = "123";
    public void testMethod() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                lock = "456";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyService service = new MyService();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.testMethod();
            }
        },"T1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.testMethod();
            }
        },"T2");


        t1.start();
        Thread.sleep(50);// 存在50ms
        t2.start();

        //当注释掉Thread.sleep(50) 之后，两个线程几乎同时运行，
        //t1先运行，拿到锁打印begin，t2请求锁，发现被占用，则等待锁被释放，
        // 期间不会再请求锁，等待锁被释放（t1执行完 ），则会再去请求锁。
        //
        //t1先运行，拿到锁打印begin，修改锁，t2请求锁，发现锁456 没有线程在占有，故进入代码块执行
        //此时会打印两个 begin

    }
}
