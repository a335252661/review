package A1_多线程.other.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/2/25
 */
public class Mytest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 30; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }


        executorService.shutdown();
    }

}
