package A1_多线程.A31_wait_notify机制.A3119生产者消费者模式的实现.A31192允许连续生产多个允许连续消费多个;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class Box {
    private static List list = new ArrayList();
    synchronized public void add() {
        if (size() < 50) {
            list.add("anyString");
            System.out.println("线程：" + Thread.currentThread().getName() + "执行add()方法，size大小为：" + size());
        }
    }
    synchronized public int size() {
        return list.size();
    }
    synchronized public Object popFirst() {
        Object value = list.remove(0);
        System.out.println("线程：" + Thread.currentThread().getName() + "执行popFirst()方法，size大小为：" + size());
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        Box box = new Box();
        SetService setService = new SetService(box);
        for (int i = 0; i < 2; i++) { //两个线程开启，作为生产者  //生产了50个则waiting
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    setService.setMethod();
//                }
//            }).start();

            SetValueThread setValueThread1 =
                    new SetValueThread(setService);
            setValueThread1.start();

        }

        Thread.sleep(50);

        //开启一个线程，用于检查集合大小， box.size() < 50  ，唤醒所有线程
        SetCheckThread setCheckThread = new SetCheckThread(setService);
        setCheckThread.start();
/////
        Thread.sleep(10000);
        GetService getService = new GetService(box);
        for (int i = 0; i < 10; i++) {  //开启十个消费者线程
            GetValueThread getValueThread1 = new GetValueThread(getService);
            getValueThread1.start();
        }
        Thread.sleep(50);
        GetCheckThread getCheckThread = new GetCheckThread(getService); // box.size() > 0则唤醒所有消费者
        getCheckThread.start();
    }

}
