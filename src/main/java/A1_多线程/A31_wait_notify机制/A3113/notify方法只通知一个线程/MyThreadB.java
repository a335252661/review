package A1_多线程.A31_wait_notify机制.A3113.notify方法只通知一个线程;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class MyThreadB extends Thread{
    private MyService service;
    public MyThreadB(MyService service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.notifyMethod();
    }
}
