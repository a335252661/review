package A1_JUC练习.A1_04_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/23
 */
public class QueueDemo {

    public static void main(String[] args) throws Exception{
//        addAndRemove();
//        offerAndPoll();
//        offerAndPollTomeOut();
//        putAndTack();


        synchronousQueueFun();


    }

    private static void synchronousQueueFun() {
        BlockingQueue<String> blockingQueue = new SynchronousQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"  1放入完成");
                    blockingQueue.put("1");
                    System.out.println(Thread.currentThread().getName()+"  2放入完成");
                    blockingQueue.put("2");
                    System.out.println(Thread.currentThread().getName()+"  3放入完成");
                    blockingQueue.put("3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程a").start();
        try { TimeUnit.SECONDS.sleep(3);  } catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(blockingQueue.take() +"   被取走");
                    System.out.println(blockingQueue.take() +"   被取走");
                    System.out.println(blockingQueue.take() +"   被取走");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程b").start();
    }

    private static void putAndTack() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.take(); //队列里面没有元素，直接取也会阻塞
        blockingQueue.put("a");
        blockingQueue.put("b");  //放两个元素，放进去直接结束
//        blockingQueue.put("c");
//        blockingQueue.put("d"); //第三个元素放满了，再放第四个元素时候，会阻塞等待，等待头部出去一个元素，他才能进去
    }

    private static void offerAndPoll() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));


        System.out.println(blockingQueue.peek()+"  检查头部元素");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

    }
    private static void offerAndPollTomeOut() throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a" ,2 , TimeUnit.SECONDS)); //true
        System.out.println(blockingQueue.offer("b" ,2 , TimeUnit.SECONDS)); //true
        System.out.println(blockingQueue.offer("c" ,2 , TimeUnit.SECONDS)); //true

        System.out.println(blockingQueue.offer("d" ,2 , TimeUnit.SECONDS)); //false
        try { TimeUnit.SECONDS.sleep(3);  } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(blockingQueue.poll());  //a

        System.out.println(blockingQueue.offer("d" ,5 , TimeUnit.SECONDS)); //true

        System.out.println(blockingQueue.peek()+"  检查头部元素");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

    }

    private static void addAndRemove() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d"));


        System.out.println(blockingQueue.element()); //检查头元素

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());  //java.util.NoSuchElementException
    }

}
