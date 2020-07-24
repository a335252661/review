package A1_多线程.A32_join.A325_join方法后面的代码提前运行;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 *
 * begin A ThreadName=Thread-1 1595582725218
 *  end A ThreadName=Thread-1 1595582725719
 *  main end 1595582725719
 * begin B ThreadName=Thread-0 1595582725719
 *  end B ThreadName=Thread-0 1595582726219
 */
public class Run1 {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start(); // 锁为 b对象锁 sleep5000    打印begin A
            b.start(); // 锁为 b对象锁 sleep5000
            b.join(200); //阻塞后续打印语句，立即释放b对象锁。
            System.out.println(" main end "
                    + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
