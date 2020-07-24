package A1_多线程.A71_线程的状态.A711验证NEW和RUNNABLE和TERMINATED;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class MyThread extends Thread{
    public MyThread() {
        System.out.println("构造方法中的状态 Thread.currentThread().getState()=" + Thread.currentThread().getState());//RUNNABLE
        System.out.println("构造方法中的状态 this.getState()=" + this.getState());//NEW
    }
    @Override
    public void run() {
        System.out.println("run方法中的状态：" + Thread.currentThread().getState());
    }

    public static void main(String[] args) {
        try {
            MyThread t = new MyThread();
            System.out.println("main方法中的状态1：" + t.getState());
            Thread.sleep(1000);
            t.start();
            Thread.sleep(1000);
            System.out.println("main方法中的状态2：" + t.getState());
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
