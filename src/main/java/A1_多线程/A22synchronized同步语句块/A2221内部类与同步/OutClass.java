package A1_多线程.A22synchronized同步语句块.A2221内部类与同步;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 *
 * 由于持有不同的锁，所以输出结果是乱序的。
 */
public class OutClass {
    static class Inner {  //静态内部类
        public void method1() {
            synchronized ("其他的锁") {  // 同步代码块常量池任意锁
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        public synchronized void method2() {  //同步方法对象锁
            for (int i = 11; i <= 20; i++) {
                System.out.println(Thread.currentThread().
                        getName() + " i=" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        final Inner inner = new Inner();  // 静态内部类可以直接实例化创建对象

        //同一个对象

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                inner.method1();
            }
        }, "A");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                inner.method2();
            }
        }, "B");
        t1.start();
        t2.start();
    }

}
