package A1_多线程.A31_wait_notify机制.A3115wait_long方法的基本使用;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class MyRunnable {
    static private Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin timer="
                            + System.currentTimeMillis());
                    lock.wait(5000);   //五秒之后，该线程自动唤醒
                    System.out.println("wait end timer="
                            + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    public static void main(String[] args) {
        Thread t = new Thread(runnable1);
        t.start();
    }
}
