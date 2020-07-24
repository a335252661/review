package A1_多线程.A31_wait_notify机制.A3116wait_long方法自动向下运行需要重新持有锁;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class MyThreadA extends Thread{
    private MyService service;
    public MyThreadA(MyService service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.testMethod();
    }
}
