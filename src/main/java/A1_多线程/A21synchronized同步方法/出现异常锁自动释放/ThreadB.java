package A1_多线程.A21synchronized同步方法.出现异常锁自动释放;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        super.run();
        service.testMethod();
    }
}
