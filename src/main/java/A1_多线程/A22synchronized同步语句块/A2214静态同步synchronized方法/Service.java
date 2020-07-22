package A1_多线程.A22synchronized同步语句块.A2214静态同步synchronized方法;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 * <p>
 * synchronized关键字加到static
 * 静态方法上的方式是将Class类对象作为锁，而
 * synchronized关键字加到非static静态方法上的方式是
 * 将方法所在类的对象作为锁。
 * 和对象锁不是通一把锁
 */
public class Service {
    synchronized public static void printA() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "进入printA");
            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    synchronized public static void printB() {
//        System.out.println("线程名称为：" + Thread.currentThread().getName()
//                + "在" + System.currentTimeMillis() + "进入printB");
//        System.out.println("线程名称为：" + Thread.currentThread().getName()
//                + "在" + System.currentTimeMillis() + "离开printB");
//    }


    public static void printB() {
        synchronized (Service.class) {     //依然同步，说明静态锁  synchronized public static  和 synchronized（calss）是同一把锁
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "进入printB");
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "离开printB");
        }
    }

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();
    }
}
