package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class ThreadP extends Thread{
    private P p;

    public ThreadP(P p){
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.setValue();
        }
    }
}
