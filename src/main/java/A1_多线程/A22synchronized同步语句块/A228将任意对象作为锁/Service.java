package A1_多线程.A22synchronized同步语句块.A228将任意对象作为锁;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 *
 *
 * 多个线程调用同一个对象中的不同名称的
 * synchronized同步方法或synchronized（this）同步代
 * 码块时，调用的效果是按顺序执行，即同步。
 * synchronized同步方法或synchronized（this）同
 * 步代码块分别有两种作用。
 * synchronized同步方法的作用：
 * 1）对其他synchronized同步方法或
 * synchronized（this）同步代码块调用呈同步效果。
 * 2）同一时间只有一个线程可以执行synchronized
 * 同步方法中的代码。
 * synchronized（this）同步代码块的作用：
 * 1）对其他synchronized同步方法或
 * synchronized（this）同步代码块调用呈同步效果。
 * 2）同一时间只有一个线程可以执行
 * synchronized（this）同步代码块中的代码。
 *
 * 除了使用synchronized（this）格式来创建同步代
 * 码块，其实Java还支持将“任意对象”作为锁来实现同
 * 步的功能，这个“任意对象”大多数是实例变量及方法
 * 的参数。使用格式为synchronized（非this对象）。
 * synchronized（非this对象x）同步代码块的作
 * 用：当多个线程争抢相同的“非this对象x”的锁时，同
 * 一时间只有一个线程可以执行synchronized（非this对
 * 象x）同步代码块中的代码。
 *
 * 锁非this对象具有一定的优点：如果一个类中有
 * 很多个synchronized方法，则这时虽然能实现同步，
 * 但影响运行效率，如果使用同步代码块锁非this对
 * 象，则synchronized（非this）代码块中的程序与同步
 * 方法是异步的，因为有两把锁，不与其他锁this同步
 * 方法争抢this锁，可大大提高运行效率。
 */
public class Service {
    private String usernameParam;
    private String passwordParam;
    private String anyString = new String();
    public void setUsernamePassword(String username, String password) {
        try {
            synchronized (anyString) {
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                        + System.currentTimeMillis() + "进入同步块");
                usernameParam = username;
                Thread.sleep(3000);//模拟处理数据需要的耗时
                passwordParam = password;
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                        + System.currentTimeMillis() + "离开同步块");
            }
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
