package A1_多线程.A10_常用方法.A103join;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class TestJoin {
    public void fun() {
        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+"-"+i);
        }
    }

    public static void main(String[] args) throws Exception{
        TestJoin testJoin = new TestJoin();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                testJoin.fun();
            }
        },"T1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testJoin.fun();
            }
        },"T2");

        t1.start();
        System.out.println(t1.isAlive());
        t1.join(); //是一个同步方法synchronized， 会阻塞main线程 ，
        t2.start();

//        t1.start();
//        t2.start();

    }
}
