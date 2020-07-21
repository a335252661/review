package A1_多线程.A22synchronized同步语句块.A225synchronized代码块间的同步性;

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
