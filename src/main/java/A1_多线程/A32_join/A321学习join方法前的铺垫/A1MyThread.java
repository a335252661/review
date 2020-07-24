package A1_多线程.A32_join.A321学习join方法前的铺垫;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class A1MyThread extends Thread{
    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        A1MyThread threadTest = new A1MyThread();
        threadTest.start();
// Thread.sleep(?)
        System.out.println("main线程想实现当threadTest对象执行完毕后我再继续向下执行,");
        System.out.println("但上面代码中的sleep()中的值应该写多少呢？");
        System.out.println("答案是：不能确定");
    }

}
