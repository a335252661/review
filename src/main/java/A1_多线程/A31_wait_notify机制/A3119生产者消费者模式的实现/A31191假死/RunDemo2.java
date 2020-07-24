package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.A31191假死;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 *
 * 在代码中确实已经通过wait/notify进行通信了，
 * 但不保证notify唤醒的是异类，也许是同类，如“生产
 * 者”唤醒“生产者”，或“消费者”唤醒“消费者”这样的
 * 情况，如果这样的情况积少成多，就会导致所有的
 * 线程都不能继续运行下去，大家都在等待，都呈
 * waiting状态，程序最后就呈“假死”状态，不能继续运
 * 行下去了。
 */
public class RunDemo2 {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Pdemo2 p = new Pdemo2(lock);
        Cdemo2 r = new Cdemo2(lock);
        ThreadPdemo2[] pThread = new ThreadPdemo2[2];
        ThreadCdemo2[] rThread = new ThreadCdemo2[2];
        for (int i = 0; i < 2; i++) {
            pThread[i] = new ThreadPdemo2(p);
            pThread[i].setName("生产者" + (i + 1));
            rThread[i] = new ThreadCdemo2(r);
            rThread[i].setName("消费者" + (i + 1));
            pThread[i].start();
            rThread[i].start();
        }
        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread()
                .getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup()
                .enumerate(threadArray);
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName() + " "
                    + threadArray[i].getState());
        }
    }
}
