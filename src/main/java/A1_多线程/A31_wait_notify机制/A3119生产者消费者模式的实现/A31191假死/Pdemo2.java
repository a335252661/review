package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.A31191假死;

import A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.ValueObject;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class Pdemo2 {
    private String lock;
    public Pdemo2(String lock) {
        super();
        this.lock = lock;
    }
    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者 "
                            + Thread.currentThread().getName() + " WAITING了★");
                    lock.wait();
                }
                System.out.println("生产者 " + Thread.currentThread().getName()
                        + " RUNNABLE了");
                String value = System.currentTimeMillis() + "_"
                        + System.nanoTime();
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
