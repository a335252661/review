package A1_多线程.A23_volatile关键字.A231可见性的测试.A2311synchronized代码块具有增加可见性的作用;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 */
public class Service {
    private boolean isContinueRun = true;
    public void runMethod() {
        while (isContinueRun == true) {
            synchronized ("aa"){};//关键字synchronized具有增加可视性的作用
        }
        System.out.println("停下来了！");
    }
    public void stopMethod() {
        isContinueRun = false;
    }

    public static void main(String[] args) {
        try {
            Service service = new Service();

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    service.runMethod();
                }
            },"T1");
            thread.start();

            Thread.sleep(1000);

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    service.stopMethod();
                }
            },"T2");
            thread2.start();

        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
