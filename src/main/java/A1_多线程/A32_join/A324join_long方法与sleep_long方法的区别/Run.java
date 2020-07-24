package A1_多线程.A32_join.A324join_long方法与sleep_long方法的区别;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 *
 * 由于线程ThreadA使用Thread.sleep（6000）方法
 * 一直持有ThreadB对象的锁，时间达到6s，所以线程
 * ThreadC只有在ThreadA时间到达6s后释放ThreadB的
 * 锁时，才可以调用ThreadB中的同步方法synchronized
 * public void bService()。
 */
public class Run {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(b);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
