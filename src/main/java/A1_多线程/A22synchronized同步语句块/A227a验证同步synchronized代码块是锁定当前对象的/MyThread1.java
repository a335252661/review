package A1_多线程.A22synchronized同步语句块.A227a验证同步synchronized代码块是锁定当前对象的;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 */
public class MyThread1 extends Thread{
    private Task task;
    public MyThread1(Task task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
