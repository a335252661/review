package A1_多线程.A22_synchronized同步语句块.A2215静态同步锁对所有对象实例起作用;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 */
public class ThreadA2215 extends Thread{
    private Service2215 service;
    public ThreadA2215(Service2215 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.printA();
    }
}
