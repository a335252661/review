package A1_JUC练习.A1_02_锁.公平锁和非公平锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/22
 */
public class LookDemo {

    public static void main(String[] args) {


        Lock reentrantLock = new ReentrantLock();
        Lock reentrantLock2 = new ReentrantLock(true);

    }

}
