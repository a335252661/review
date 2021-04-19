package A1_多线程.A22_synchronized同步语句块.A227a验证同步synchronized代码块是锁定当前对象的;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 *
 * 同步输出的原因是使用synchronized（this）同步
 * 代码块将当前类的对象作为锁，使用synchronized
 * public void otherMethod()同步方法将当前方法所在类
 * 的对象作为锁，都是一把锁，所以运行结果呈同步
 * 的效果。
 *
 *
 */
public class Task {
//    public void otherMethod() {
        synchronized void otherMethod() {   // 同步方法将当前方法所在类的对象作为锁，都是一把锁
        System.out.println("------------------------run--otherMethod");
    }

    public void doLongTimeTask() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("synchronized threadName="
                        + Thread.currentThread().getName() + " i=" + (i + 1));
            }
        }
    }
    public static void main(String[] args)
            throws InterruptedException {
        Task task = new Task();
        MyThread1 thread1 = new MyThread1(task);
        thread1.start();  //doLongTimeTask
        Thread.sleep(100);
        MyThread2 thread2 = new MyThread2(task);
        thread2.start();  //otherMethod
    }
}
