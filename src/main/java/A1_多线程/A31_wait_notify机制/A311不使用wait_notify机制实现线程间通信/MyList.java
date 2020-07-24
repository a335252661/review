package A1_多线程.A31_wait_notify机制.A311不使用wait_notify机制实现线程间通信;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class MyList {
    volatile private List list = new ArrayList();
    public void add() {
        list.add("高洪岩");
    }
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyList service = new MyList();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }

}
