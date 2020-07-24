package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现;


/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class C {
    private String lock;
    public C(String lock) {
        super();
        this.lock = lock;
    }
    public void getValue() {
        try {
            synchronized (lock) {
                if (ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get的值是" + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
