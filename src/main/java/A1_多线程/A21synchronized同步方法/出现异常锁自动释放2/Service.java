package A1_多线程.A21synchronized同步方法.出现异常锁自动释放2;

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
public class Service extends Thread{
    @Override
    public void run() {
        testMethod();
    }
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

            Thread threada = new Thread(service);
            threada.setName("a");
            threada.start();

            Thread.sleep(500);

            Thread threadb = new Thread(service);
            threadb.setName("b");
            threadb.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
