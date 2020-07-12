package A1_多线程.thread;

/**
 * @author by cld
 * @date 2020/7/12  10:22
 * @description:
 */
public class Thread01{
    public static void main(String[] args) {
        ThreadRun01 ob = new ThreadRun01();
        ob.start();

        ThreadRun01 ob2 = new ThreadRun01();
        ob2.start();
    }
}
