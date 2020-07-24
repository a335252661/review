package A1_多线程.A23_volatile关键字.A232非原子性的测试;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 *
 * 输出顺序出错了，应该每加1次100再加1次1，
 * 出现这种情况是因为addAndGet()方法是原子的，但
 * 方法和方法之间的调用不是原子的，解决这种问题
 * 必须用同步了。
 */
public class A3atomicIntergerNoSafe {
    public static AtomicLong aiRef = new AtomicLong();
    public void addNum() {
        System.out.println(Thread.currentThread().getName() + "加了100之后的值是:" + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }

    public static void main(String[] args) throws Exception{
        A3atomicIntergerNoSafe a3atomicIntergerNoSafe = new A3atomicIntergerNoSafe();

        for(int i=0 ; i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    a3atomicIntergerNoSafe.addNum();
                }
            },"T"+i).start();
        }

        Thread.sleep(1000);
        System.out.println(a3atomicIntergerNoSafe.aiRef.get());

    }
}
