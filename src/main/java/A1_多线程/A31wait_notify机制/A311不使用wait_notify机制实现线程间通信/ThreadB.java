package A1_多线程.A31wait_notify机制.A311不使用wait_notify机制实现线程间通信;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 */
public class ThreadB extends Thread{
    private MyList list;
    public ThreadB(MyList list) {
        super();
        this.list = list;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                System.out.println("B线程醒了，此时list.size()=" +list.size());
                if (list.size() == 5) {
                    System.out.println("==5了，线程b要退出了！");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
