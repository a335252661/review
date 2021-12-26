package A1_JUC练习.A1_07_线程池;

import java.util.concurrent.*;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/25
 */
public class MyExecutorPool02 {
    private static final int COUNT_BITS = Integer.SIZE - 3; // 29   //Integer.SIZE = 32
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;  //把 1左移29位，就是右边补29个0
    public static void main(String[] args) {

        System.out.println(COUNT_BITS);
        System.out.println(CAPACITY);
    }

}
