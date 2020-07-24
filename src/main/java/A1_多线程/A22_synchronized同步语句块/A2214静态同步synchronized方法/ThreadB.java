package A1_多线程.A22_synchronized同步语句块.A2214静态同步synchronized方法;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 */
public class ThreadB extends Thread{
    @Override
    public void run() {
        Service.printB();
    }
}
