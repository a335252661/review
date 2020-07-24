package A1_多线程.A71_线程的状态.A714验证WAITING;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class MyThread extends Thread{

    public static final Byte lock = new Byte("0");

    @Override
    public void run() {
        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //WAITING
    public static void main(String[] args) {
        try {
            MyThread t = new MyThread();
            t.start();
            Thread.sleep(1000);
            System.out.println("main方法中的t状态：" + t.getState());
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
