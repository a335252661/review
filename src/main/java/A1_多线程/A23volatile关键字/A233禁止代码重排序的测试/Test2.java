package A1_多线程.A23volatile关键字.A233禁止代码重排序的测试;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class Test2 {
    private static long x = 0;
    private static long y = 0;
    private static long a = 0;
    private static long b = 0;
    private static long c = 0;
    volatile private static long d = 0;
    private static long e = 0;
    volatile private static long f = 0;
    private static long count = 0;
    public static void main(String[] args) throws InterruptedException {
        for (;;) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            count++;
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    a = 1;
                    c = 101;
                    x = b;
                    d = 102;
                }
            });
            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    e = 201;
                    y = a;
                    f = 202;
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            String showString = "count=" + count + " " + x + "," + y + "";
            if (x == 0 && y == 0) {
                System.err.println(showString);
                break;
            } else {
                System.out.println(showString);
            }
        }
    }
}
