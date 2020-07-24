package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.A31192允许连续生产多个允许连续消费多个;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class SetValueThread extends Thread{
    private SetService service;
    public SetValueThread(SetService service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        while (true) {
            service.setMethod();
        }
    }
}
