package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);
        ThreadP pThread = new ThreadP(p);
        ThreadC rThread = new ThreadC(r);
        pThread.start();
        rThread.start();
    }
}
