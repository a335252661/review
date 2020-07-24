package A1_多线程.A32_join.A324join_long方法与sleep_long方法的区别;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class ThreadB extends Thread{
    @Override
    public void run() {
        try {
            System.out.println(" b run begin timer="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(" b run end timer="
                    + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void bService() {
        System.out.println("打印了bService timer=" + System.currentTimeMillis());
    }
}
