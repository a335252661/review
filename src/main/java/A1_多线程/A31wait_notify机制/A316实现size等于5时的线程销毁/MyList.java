package A1_多线程.A31wait_notify机制.A316实现size等于5时的线程销毁;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class MyList {
    private static List list = new ArrayList();
    public static void add() {
        list.add("anyString");
    }
    public static int size() {
        return list.size();
    }

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
