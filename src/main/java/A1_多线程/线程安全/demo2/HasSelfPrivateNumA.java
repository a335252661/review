package A1_多线程.线程安全.demo2;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class HasSelfPrivateNumA extends Thread {
    private HasSelfPrivateNum numRef;
    public HasSelfPrivateNumA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
