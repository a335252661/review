package A1_多线程.A32_join.A324join_long方法与sleep_long方法的区别;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class ThreadC extends Thread {
    private ThreadB threadB;
    public ThreadC(ThreadB threadB) {
        super();
        this.threadB = threadB;
    }
    @Override
    public void run() {
        threadB.bService();
    }
}
