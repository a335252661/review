package A1_多线程.A22_synchronized同步语句块.A223用同步代码块解决同步方法的弊端;

import A1_多线程.A22_synchronized同步语句块.A221synchronized方法的弊端.CommonUtils;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 *
 * 通过上面的示例可以知道，当一个线程访问
 * object的一个synchronized同步代码块时，另一个线程
 * 仍然可以访问该object对象中的非
 * synchronized（this）同步代码块。
 * 在本示例中，运行时间虽然缩短，加快了运行
 * 效率，但同步synchronized（this）代码块真的是同步
 * 的吗？真的持有当前调用对象的锁吗？答案为是，
 * 但必须用代码的方式来进行验证。
 */
public class Task {
    private String getData1;
    private String getData2;
    public  void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);

            synchronized(this){
                getData1 = "长时间处理任务后从远程返回的值1 threadName="
                        + Thread.currentThread().getName();
                getData2 = "长时间处理任务后从远程返回的值2 threadName="
                        + Thread.currentThread().getName();
                System.out.println(getData1);
                System.out.println(getData2);
                System.out.println("end task");
            }
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        MyThread3 thread1 = new MyThread3(task);
        thread1.start();
        MyThread4 thread2 = new MyThread4(task);
        thread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }
        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }
        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }
}
