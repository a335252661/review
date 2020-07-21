package A1_多线程.A21synchronized同步方法.demo1;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class HasSelfPrivateNumRun {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        HasSelfPrivateNumA athread = new HasSelfPrivateNumA(numRef);
        athread.start();
        HasSelfPrivateNumB bthread = new HasSelfPrivateNumB(numRef);
        bthread.start();
    }
}
