package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.A31191假死;

import A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.ValueObject;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class Cdemo2 {
    private String lock;
    public Cdemo2(String lock) {
        super();
        this.lock = lock;
    }
    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.value.equals("")) {
                    System.out.println("消费者 "
                            + Thread.currentThread().getName() + " WAITING了☆");
                    lock.wait();
                }
                System.out.println("消费者 " + Thread.currentThread().getName()
                        + " RUNNABLE了");
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
