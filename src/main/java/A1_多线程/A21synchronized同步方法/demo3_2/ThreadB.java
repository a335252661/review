package A1_多线程.A21synchronized同步方法.demo3_2;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class ThreadB extends Thread{
    private MyObject object;
    public ThreadB(MyObject object) {
        super();
        this.object = object;
    }
    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}
