package A1_多线程.A21synchronized同步方法.锁重入支持继承;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateISubMethod();
    }
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
