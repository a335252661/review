//package A1_多线程.A34_线程池.A341_基础;
//
//import java.util.concurrent.BlockingDeque;
//import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author 程刘德
// * @version 1.0
// * @Description TODO
// * @date 2021/12/26
// *     public ThreadPoolExecutor(int corePoolSize, //核心线程数
// *                               int maximumPoolSize, //同时执行的最大线程数
// *                               long keepAliveTime, //保持空闲时间
// *                               TimeUnit unit, //时间单位
// *                               BlockingQueue<Runnable> workQueue, //阻塞队列
// *                               ThreadFactory threadFactory, //线程工厂
// *                               RejectedExecutionHandler handler) { //拒绝策略
// */
//public class LearnThread {
//    public static void main(String[] args) {
//        //存放任务的阻塞队列
//        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(10);
//        //BasicThreadFactory是自己实现ThreadFactory接口而来
//        BasicThreadFactory factory = new BasicThreadFactory();
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,
//                10,
//                60,
//                TimeUnit.SECONDS,
//                queue,
//                factory,
//                (Runnable r, ThreadPoolExecutor executor) -> {
//                    System.out.println(executor.getQueue().size() + "消息队列已满");
//                    System.out.println("拒绝服务");
//
//                });
//    }
//}
