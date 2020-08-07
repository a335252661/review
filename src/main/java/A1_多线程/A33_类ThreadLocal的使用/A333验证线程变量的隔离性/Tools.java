package A1_多线程.A33_类ThreadLocal的使用.A333验证线程变量的隔离性;

import java.io.IOException;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/27
 */
public class Tools {
    public static ThreadLocal tl = new ThreadLocal();

    public static void main(String[] args) throws IOException, InterruptedException {
        MyThreadA a = new MyThreadA();
        MyThreadB b = new MyThreadB();
        a.start();
        b.start();
        for (int i = 0; i < 10; i++) {
            Tools.tl.set("main " + (i + 1));
            System.out.println(" main get " + Tools.tl.get());
            int sleepValue = (int) (Math.random() * 1000);
            Thread.sleep(sleepValue);
        }
    }
}
