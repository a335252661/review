package A1_多线程.A22_synchronized同步语句块.A221synchronized方法的弊端;

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
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
