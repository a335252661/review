package A1_JUC练习.A1_07_线程池;

import java.util.concurrent.*;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/25
 */
public class MyExecutorPool {

    public static void main(String[] args) {
//        一池一线程
//        一池多线程
//        ExecutorService executorService = Executors.newFixedThreadPool(5);//池子中，五个线程,适合执行长期的任务
//        ExecutorService executorService = Executors.newSingleThreadExecutor();//池子中，1个线程，一个任务一个任务的执行
//        ExecutorService executorService = Executors.newCachedThreadPool();//池子中，n个线程，适合很多短期异步的任务

        System.out.println("cpu 核心数：" +Runtime.getRuntime().availableProcessors());
        //手写一个线程池
        // RejectedExecutionException  爆出异常
        ExecutorService executorService =new ThreadPoolExecutor(
                2, //两个核心不会被销毁
                50, // 包括两个核心线程 ， 三个 是加班的线程
                60, //表示线程的空闲时间超时60 秒 就会被销毁，
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            // 例子：十个人到银行办理业务，银行只开放了五个窗口
            for (int i = 0; i < 1000; i++) {
                //void execute(Runnable command);
                executorService.execute(()->{
                    try { TimeUnit.SECONDS.sleep(1);  } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }

}
