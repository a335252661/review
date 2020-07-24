package A1_多线程.A32_join.A325_join方法后面的代码提前运行;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class ThreadA extends Thread {
    private ThreadB b;
    public ThreadA(ThreadB b) {
        super();
        this.b = b;
    }
    @Override
    public void run() {
        try {
            synchronized (b) {
                System.out.println("begin A ThreadName="
                        + Thread.currentThread().getName() + " "
                        + System.currentTimeMillis());
                Thread.sleep(500);
                System.out.println(" end A ThreadName="
                        + Thread.currentThread().getName() + " "
                        + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
