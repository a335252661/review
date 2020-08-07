package A1_多线程.A33_类ThreadLocal的使用.A333验证线程变量的隔离性;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/27
 */
public class MyThreadA extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Tools.tl.set("A " + (i + 1));
                System.out.println("A get " + Tools.tl.get());
                int sleepValue = (int) (Math.random() * 1000);
                Thread.sleep(sleepValue);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
