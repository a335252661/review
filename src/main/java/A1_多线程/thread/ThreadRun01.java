package A1_多线程.thread;

/**
 * @author by cld
 * @date 2020/7/12  10:30
 * @description:
 */
public class ThreadRun01 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
