package A1_多线程.A21synchronized同步方法.demo3_1;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class ThreadA extends Thread{
    private MyObject object;
    public ThreadA(MyObject object) {
        super();
        this.object = object;
    }
    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
