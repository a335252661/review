package A1_多线程.A22_synchronized同步语句块.A227任意锁和this锁异步;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 *
 * 锁非this对象具有一定的优点：如果一个类中有
 * 很多个synchronized方法，则这时虽然能实现同步，
 * 但影响运行效率，如果使用同步代码块锁非this对
 * 象，则synchronized（非this）代码块中的程序与同步
 * 方法是异步的，因为有两把锁，不与其他锁this同步
 * 方法争抢this锁，可大大提高运行效率。
 *
 * 由于锁不同，所以运行结果是异步的。
 */
public class ObjectService {
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("A begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end end=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void serviceMethodB() {
        synchronized (new String()) {
            System.out.println("B begin time=" + System.currentTimeMillis());
            System.out.println("B end end=" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
    }
}
