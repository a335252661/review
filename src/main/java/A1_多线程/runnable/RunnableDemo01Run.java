package A1_多线程.runnable;

/**
 * @author by cld
 * @date 2020/7/12  10:33
 * @description:
 */
public class RunnableDemo01Run implements Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
