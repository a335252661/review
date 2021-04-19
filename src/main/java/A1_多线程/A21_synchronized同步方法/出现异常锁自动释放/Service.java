package A1_多线程.A21_synchronized同步方法.出现异常锁自动释放;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/17
 *
 * 线程a出现异常并释放锁，线程b进入方法正常输
 * 出。本示例说明，当出现异常时，锁可以自动释
 * 放。
 * 要注意，类Thread.java中的suspend()方法和
 * sleep（millis）方法被调用后并不释放锁。
 */
public class Service {
    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + " run beginTime=" + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThreadName="
                            + Thread.currentThread().getName()
                            + " run exceptionTime="
                            + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread B run Time="
                    + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        try {
            Service service = new Service();
//            ThreadA a = new ThreadA(service);
//            a.setName("a");
//            a.start();
//            Thread.sleep(500);
//            ThreadB b = new ThreadB(service);
//            b.setName("b");
//            b.start();

            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    service.testMethod();
                }
            }, "a");
            a.start();
            Thread.sleep(500);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.testMethod();
                }
            },"b").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
