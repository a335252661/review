package A1_多线程.A22synchronized同步语句块.A2219多线程的死锁;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 *
 * 同步代码块任意锁
 * 两个线程在同步代码块任意锁中，下一步操作是同步锁被对方占有，且在互相等待
 */
public class DealThread implements Runnable {
    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();
    public void setFlag(String username) {
        this.username = username;
    }
    public void run() {
        if (username.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("按lock1->lock2代码顺序执行了");
                }
            }
        }
        if (username.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("按lock2->lock1代码顺序执行了");
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            DealThread t1 = new DealThread();
            t1.setFlag("a");

            Thread thread1 = new Thread(t1);
            thread1.start();

            Thread.sleep(100);

            t1.setFlag("b");
            Thread thread2 = new Thread(t1);
            thread2.start();
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
