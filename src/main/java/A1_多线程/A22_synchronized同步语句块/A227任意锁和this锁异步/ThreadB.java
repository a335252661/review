package A1_多线程.A22_synchronized同步语句块.A227任意锁和this锁异步;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 */
public class ThreadB extends Thread{
    private ObjectService service;
    public ThreadB(ObjectService service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        super.run();
        service.serviceMethodB();
    }
}
