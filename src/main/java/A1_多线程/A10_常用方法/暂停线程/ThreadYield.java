package A1_多线程.A10_常用方法.暂停线程;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class ThreadYield extends Thread{

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();  //将cpu时间片让出去，谁活的不一定，可能有事自己获取到了
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + "毫秒！");
    }

    public static void main(String[] args) {
        ThreadYield thread = new ThreadYield();
        thread.start();
    }

}
