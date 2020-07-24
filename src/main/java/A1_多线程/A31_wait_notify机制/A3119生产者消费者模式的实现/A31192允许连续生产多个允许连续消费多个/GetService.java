package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.A31192允许连续生产多个允许连续消费多个;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class GetService {
    private Box box;
    public GetService(Box box) {
        super();
        this.box = box;
    }
    public void getMethod() {
        try {
            synchronized (this) {
                while (box.size() == 0) {
                    System.out.println("○○○○○");
                    this.wait();
                }
                box.popFirst();
            }
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void checkBoxStatus() {
        try {
            while (true) {
                synchronized (this) {
                    if (box.size() > 0) {
                        this.notifyAll();
                    }
                }
                System.out.println("get checkboxBox = " + box.size());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
