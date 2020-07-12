package A1_多线程.threadPool;

/**
 * @author by cld
 * @date 2020/7/12  10:47
 * @description:
 */
public class ThreadPool01Run implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
