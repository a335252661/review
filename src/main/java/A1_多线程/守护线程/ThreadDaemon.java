package A1_多线程.守护线程;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class ThreadDaemon  extends Thread {

    private int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ThreadDaemon thread = new ThreadDaemon();
//            thread.setDaemon(true);   // 则当前线程是main线程的守护线程  ，main线程结束 则Thread01线程也结束
            thread.start();
            Thread.sleep(5000);
            System.out.println("我离开thread对象也不再打印了，也就是停止了！");
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
