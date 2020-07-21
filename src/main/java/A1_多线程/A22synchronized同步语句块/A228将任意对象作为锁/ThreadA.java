package A1_多线程.A22synchronized同步语句块.A228将任意对象作为锁;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 */
public class ThreadA extends Thread{
    private Service service;
    public ThreadA(Service service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.setUsernamePassword("a", "aa");
    }
}
