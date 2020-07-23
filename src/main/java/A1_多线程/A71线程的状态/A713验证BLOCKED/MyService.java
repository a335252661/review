package A1_多线程.A71线程的状态.A713验证BLOCKED;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class MyService {
    synchronized  public void serviceMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "进入了业务方法！");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyService myService = new MyService();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.serviceMethod();
            }
        },"T1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.serviceMethod();
            }
        },"T2");

        t1.start();
        Thread.sleep(1000);
        System.out.println("main方法中的t1状态：" + t1.getState());
        t2.start();
        Thread.sleep(1000);
        System.out.println("main方法中的t2状态：" + t2.getState());
    }

}
