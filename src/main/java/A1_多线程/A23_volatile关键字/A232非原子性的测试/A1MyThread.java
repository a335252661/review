package A1_多线程.A23_volatile关键字.A232非原子性的测试;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 *
 * 运行结果不是10000，
 *
 * i++;i--  操作可以拆分成三部，1、从内存获取值，2、计算值，3、回写内存，
 * 多线程操作被volatitle修饰的实例变量的时候，假设在第二步时候，
 * 另一个线程也修改了i的值，就会回写相同的值到内存中，这个时候就会出现脏数据。
 */
public class A1MyThread extends Thread{
    volatile public static int count;
    private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }
    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        A1MyThread[] mythreadArray = new A1MyThread[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new A1MyThread();
        }
        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }
    }

}
