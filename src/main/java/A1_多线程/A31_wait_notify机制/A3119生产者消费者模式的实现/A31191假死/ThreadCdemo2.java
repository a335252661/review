package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.A31191假死;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class ThreadCdemo2 extends Thread {
    private Cdemo2 c;

    public ThreadCdemo2(Cdemo2 c){
        this.c = c;
    }

    @Override
    public void run() {
        while (true){
            c.getValue();
        }
    }
}
