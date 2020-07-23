package A1_多线程.A10常用方法.暂停线程;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class ThreadSuspend01 extends Thread{
    private long i = 0;
    public long getI() {
        return i;
    }
    public void setI(long i) {
        this.i = i;
    }
    @Override
    public void run() {
        while (true) {
            i++;
        }
    }

    public static void main(String[] args) {
        try {
            ThreadSuspend01 thread = new ThreadSuspend01();
            thread.start();
            Thread.sleep(5000);
// A段
            thread.suspend();
            System.out.println("A= " + System.currentTimeMillis() + " i="
                    + thread.getI());
            Thread.sleep(5000);
            System.out.println("A= " + System.currentTimeMillis() + " i="
                    + thread.getI());
// B段
            thread.resume();
            Thread.sleep(5000);
// C段
            thread.suspend();
            System.out.println("B= " + System.currentTimeMillis() + " i="
                    + thread.getI());
            Thread.sleep(5000);
            System.out.println("B= " + System.currentTimeMillis() + " i="
                    + thread.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
