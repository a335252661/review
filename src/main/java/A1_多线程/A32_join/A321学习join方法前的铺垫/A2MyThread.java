package A1_多线程.A32_join.A321学习join方法前的铺垫;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 *
 * join()方法的作用是使所属的线程对象x正常执行
 * run()方法中的任务，而使当前线程z进行无限期的阻
 * 塞，等待线程x销毁后再继续执行线程z后面的代
 * 码，具有串联执行的效果。
 *
 * join()方法具有使线程排队运行的效果，有些类
 * 似同步的运行效果，但是join()方法与synchronized的
 * 区别是join()方法在内部使用wait()方法进行等待，而
 * synchronized关键字使用锁作为同步。
 */
public class A2MyThread extends Thread{
    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);

            System.out.println("threadTest对象执行完毕-----");

        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            A2MyThread threadTest = new A2MyThread();
            threadTest.start();
            threadTest.join();
            System.out.println("我想当threadTest对象执行完毕后我再执行，我做到了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
