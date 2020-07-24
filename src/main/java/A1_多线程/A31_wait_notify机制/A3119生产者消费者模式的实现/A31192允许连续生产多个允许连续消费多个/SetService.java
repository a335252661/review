package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.A31192允许连续生产多个允许连续消费多个;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class SetService {
    private Box box;
    public SetService(Box box) {
        super();
        this.box = box;
    }
    public void setMethod() {
        try {
            synchronized (this) {
                while (box.size() == 50) {
                    System.out.println("●●●●●");
                    this.wait();
                }
            }
            Thread.sleep(300);
            box.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void checkBoxStatus() {
        try {
            while (true) {
                synchronized (this) {
                    if (box.size() < 50) {
                        this.notifyAll();
                    }
                }
                System.out.println("set checkboxBox = " + box.size());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
