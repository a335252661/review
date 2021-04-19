package A1_多线程.A21_synchronized同步方法.demo3_2;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 *
 * A线程先持有object对象的Lock锁，B线程如
 * 果在这时调用object对象中的synchronized类型的方
 * 法，则需要等待，也就是同步。
 *
 * 在方法声明处添加synchronized并不是锁方
 * 法，而是锁当前类的对象。
 *
 * 在Java中只有“将对象作为锁”这种说法，并
 * 没有“锁方法”这种说法。
 *
 * 在方法中使用synchronized关键字实现同步的原
 * 因是使用了flag标记ACC_SYNCHRONIZED,本例子中
 * -- 一个实例产生了两把相同的锁，b
 */
public class MyObject {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName="
                    + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end endTime=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void methodB() {
        try {
            System.out.println("begin methodB threadName="
                    + Thread.currentThread().getName() + " begin time="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //a线程调用a方法   b线程调用b方法
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object); // object 是同一个对象 ， 
        a.setName("A");
        ThreadB b = new ThreadB(object); // object
        b.setName("B");
        a.start();
        b.start();
    }
}
