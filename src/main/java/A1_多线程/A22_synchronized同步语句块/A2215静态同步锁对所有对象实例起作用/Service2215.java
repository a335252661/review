package A1_多线程.A22_synchronized同步语句块.A2215静态同步锁对所有对象实例起作用;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 *
 * 虽然是不同对象，但静态的同步方法还是同
 * 步运行
 */
public class Service2215 {
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
//    synchronized public static void printB() {  // 静态同步锁
//        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
//                + System.currentTimeMillis() + "进入printB");
//        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
//                + System.currentTimeMillis() + "离开printB");
//    }

     public  void printB() {
        synchronized (Service2215.class){  //同步代码块class锁
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                    + System.currentTimeMillis() + "进入printB");
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                    + System.currentTimeMillis() + "离开printB");
        }

    }

    public static void main(String[] args) {
        //实例化两个对象，如果用同步方法对象锁，则是两个不同的锁，是异步的
        //此时用的是静态同步锁，锁为Service2215.class  类锁是单利的，是通一把锁，是同步的
        //静态同步锁  =  同步代码块class锁
        Service2215 service1 = new Service2215();
        Service2215 service2 = new Service2215();
        ThreadA2215 a = new ThreadA2215(service1);
        a.setName("A");
        a.start();

        ThreadB2215 b = new ThreadB2215(service2);
        b.setName("B");
        b.start();
    }

}
