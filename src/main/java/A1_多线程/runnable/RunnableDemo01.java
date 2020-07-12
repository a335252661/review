package A1_多线程.runnable;

/**
 * @author by cld
 * @date 2020/7/12  10:33
 * @description:
 */
public class RunnableDemo01{

    public static void main(String[] args) {
        RunnableDemo01Run ob = new RunnableDemo01Run();
        new Thread(ob).start();

        RunnableDemo01Run ob2 = new RunnableDemo01Run();
        new Thread(ob2).start();
    }

}
