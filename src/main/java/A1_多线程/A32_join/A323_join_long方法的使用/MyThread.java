package A1_多线程.A32_join.A323_join_long方法的使用;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("run begin Timer=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("run end Timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();
            System.out.println(" main begin time=" + System.currentTimeMillis());
            threadTest.join(2000);// 只等2s
// Thread.sleep(2000);
            System.out.println(" main end time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
