package A1_多线程.A22synchronized同步语句块.A2221内部类与同步;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 *
 * 本实验测试同步代码块synchronized（lock）对
 * lock上锁后，其他线程只能以同步的方式调用lock中
 * 的同步方法。
 */
public class OutClassDemo2 {
    static class InnerClass1 {
        public void method1(InnerClass2 class2) {    //t1
            String threadName = Thread.currentThread().getName();
            synchronized (class2) {  //同步代码块任意锁--对象锁   InnerClass2 的实例对象
                System.out.println(threadName + " 进入InnerClass1类中的method1方法");
                for (int i = 0; i < 10; i++) {
                    System.out.println("i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(threadName + " 离开InnerClass1类中的method1方法");
            }
        }
        public synchronized void method2() {  //t2   同步方法对象锁  InnerClass1 的实例对象
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " 进入InnerClass1类中的method2方法");
            for (int j = 0; j < 10; j++) {
                System.out.println("j=" + j);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(threadName + " 离开InnerClass1类中的method2方法");
        }
    }
    static class InnerClass2 {
        public synchronized void method1() {  //t3    同步方法对象锁  InnerClass2 的实例对象
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " 进入InnerClass2类中的method1方法");
            for (int k = 0; k < 10; k++) {
                System.out.println("k=" + k);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(threadName + " 离开InnerClass2类中的method1方法");
        }
    }

    public static void main(String[] args) {
        final InnerClass1 in1 = new InnerClass1();
        final InnerClass2 in2 = new InnerClass2();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                in1.method1(in2);
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                in1.method2();
            }
        }, "T2");
// //
// //
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                in2.method1();
            }
        }, "T3");
        t1.start();
        t2.start();
        t3.start();
    }

}
