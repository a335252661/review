package A1_多线程.A33_类ThreadLocal的使用.A334_测试;

import java.util.concurrent.TimeUnit;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/26
 * //之前是多线程操作共享变量，会存在问题
 */
public class MyDemo {
    private static ThreadLocal<String> tl = new ThreadLocal<>();
    private static String content;
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final String data = i+"";
            new Thread(new Runnable() {
                @Override
                public void run() {
                    content = Thread.currentThread().getName()+data;
//                    System.out.println("-----------------------------------------------------");
//                    System.out.println(Thread.currentThread().getName() + "--->" + content);

                    tl.set(content);
                    System.out.println(Thread.currentThread().getName() + "--->" + tl.get());
//                    try { TimeUnit.SECONDS.sleep(1);  } catch (InterruptedException e) { e.printStackTrace(); }
                }
            },"线程"+i).start();
        }
    }
}
