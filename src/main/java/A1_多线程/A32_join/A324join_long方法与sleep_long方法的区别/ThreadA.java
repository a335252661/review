package A1_多线程.A32_join.A324join_long方法与sleep_long方法的区别;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class ThreadA extends Thread{
    private ThreadB b;
    public ThreadA(ThreadB b) {
        super();
        this.b = b;
    }
    @Override
    public void run() {
        try {
//            synchronized (b) {
//                b.start();
//                System.out.println("b线程启动，a线程在sleep，但是持有锁");
//                Thread.sleep(6000);
//                // Thread.sleep()不释放锁！
//            }


            synchronized (b) {
                b.start();
                b.join();// 执行join()方法的一瞬间，b锁立即释放
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    String newString = new String();
                    Math.random();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
