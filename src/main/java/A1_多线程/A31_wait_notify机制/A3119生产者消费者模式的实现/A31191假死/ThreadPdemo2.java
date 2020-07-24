package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.A31191假死;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class ThreadPdemo2 extends Thread{
    private Pdemo2 p;

    public ThreadPdemo2(Pdemo2 p){
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.setValue();
        }
    }
}
