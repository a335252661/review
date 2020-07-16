package A1_多线程.线程安全.demo4;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class ThreadA extends Thread{
    private PublicVar publicVar;
    public ThreadA(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }
    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}
