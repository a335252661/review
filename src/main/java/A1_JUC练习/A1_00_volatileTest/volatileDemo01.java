package A1_JUC练习.A1_00_volatileTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/21
 */
public class volatileDemo01 {

    public int num = 0;

    public static void main(String[] args) {

//        setOK();

        AtomicInteger atomicInteger = new AtomicInteger(100);
        atomicInteger.getAndAdd(2);



//        atomicInteger.getAndIncrement();

    }


    //保证可见性  num被volatile 修饰之后 ， 其他线程修改了之后，写回主内存，其他线程是可见了。使用1.8之前的版本测试
    private static void setOK() {
        volatileDemo01 volatileDemo01 = new volatileDemo01();

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName()+"---------come in");
                volatileDemo01.num = 60;
                try { TimeUnit.SECONDS.sleep(3);  } catch (InterruptedException e) { e.printStackTrace(); }

                System.out.println(Thread.currentThread().getName()+"---------come out");

            }
        },"A").start();

        //第二个线程是我们的主线程 ， volatile
        while (volatileDemo01.num == 0){

        }
        System.out.println(Thread.currentThread().getName()+"---------我知道num修改了");
    }


}
