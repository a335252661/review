package A1_多线程.A22synchronized同步语句块.A225synchronized代码块间的同步性;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 *
 * 在使用同步synchronized（this）代码块时需要注
 * 意，当一个线程访问object的一个
 * synchronized（this）同步代码块时，其他线程对同一
 * 个object中所有其他synchronized（this）同步代码块
 * 的访问将被阻塞，这说明synchronized使用的对象监
 * 视器是同一个，即使用的锁是同一个。
 *
 * 和synchronized方法一样，synchronized（this）
 * 代码块也是锁定当前对象的。
 * 227说明
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
        synchronized (this) {
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
