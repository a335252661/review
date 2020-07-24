package A1_多线程.A10_常用方法.停止线程;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/14
 */
public class MyThreadStop02 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止!进入catch!" + this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThreadStop02 thread = new MyThreadStop02();
            thread.start();
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }


}
