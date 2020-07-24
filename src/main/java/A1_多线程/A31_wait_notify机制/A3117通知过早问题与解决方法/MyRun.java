package A1_多线程.A31_wait_notify机制.A3117通知过早问题与解决方法;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class MyRun {
    private String lock = new String("");
    private Runnable runnableA = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("begin wait");
                    lock.wait();
                    System.out.println("end wait");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable runnableB = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("begin notify");
                lock.notify();
                System.out.println("end notify");
            }
        }
    };

    public static void main(String[] args) throws Exception{
        MyRun run = new MyRun();

        Thread b = new Thread(run.runnableB);
        b.start();

        Thread.sleep(100);

        Thread a = new Thread(run.runnableA);
        a.start();
    }

}
