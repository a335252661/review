package A1_多线程.暂停线程;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class ThreadSuspend03 extends Thread{

    private long i = 0;
    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);//里面会有同步锁  ，当suspend 内部暂停的时候，同步锁不会释放，资源独占，
        }
    }

    public static void main(String[] args) {
        try {
            ThreadSuspend03 thread = new ThreadSuspend03();
            thread.start();
            Thread.sleep(1000);
            thread.suspend();
            System.out.println("main end!"); //同步锁 ,  03线程正在 println 中暂停 ，同步锁不会释放 ， 故main线程不能进去，所以不会输出
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
