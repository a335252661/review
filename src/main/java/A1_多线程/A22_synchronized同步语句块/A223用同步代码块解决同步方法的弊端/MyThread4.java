package A1_多线程.A22_synchronized同步语句块.A223用同步代码块解决同步方法的弊端;

import A1_多线程.A22_synchronized同步语句块.A221synchronized方法的弊端.CommonUtils;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 */
public class MyThread4 extends Thread{
    private Task task;
    public MyThread4(Task task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}
