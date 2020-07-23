package A1_多线程.other.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by cld
 * @date 2020/7/12  10:47
 * @description:
 */
public class ThreadPool01 {

    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            exe.execute(new ThreadPool01Run());
        }
        exe.shutdown();
        while (true) {
            if (exe.isTerminated()) {
                System.out.println("所有线程运行结束");
                break;
            }
        }
    }

}
