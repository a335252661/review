package A1_多线程.A21_synchronized同步方法.demo1;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class HasSelfPrivateNumB extends Thread {
    private HasSelfPrivateNum numRef;
    public HasSelfPrivateNumB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
