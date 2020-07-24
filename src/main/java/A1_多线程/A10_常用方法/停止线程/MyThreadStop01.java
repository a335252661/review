package A1_多线程.A10_常用方法.停止线程;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * i=17928
 * i=17929
 * zzzzzzzz
 * i=17930
 * i=17931
 *
 * @date 2020/7/14
 */
public class MyThreadStop01 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 50000; i++) {
                if (this.interrupted()) { //测试当前线程是否已经是中断状态，执行后具有清除状态标志值为false的功能。
    //            if (this.isInterrupted()) {  //测试线程Thread对象是否已经是中断状态，不清除状态标志。
    //                System.out.println("已经是停止状态了!我要退出了!");
    //                break;

                    throw new InterruptedException();

                }
                System.out.println("i=" + (i + 1));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止！");

    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadStop01 thread = new MyThreadStop01();
        thread.start();
        Thread.sleep(200);
        thread.interrupt();  //这是一个标志位，标志线程可以停止，但是线程会继续运行
        System.out.println("是否停止1？="+thread.isInterrupted()); //获取标志位，
        System.out.println("是否停止2？="+thread.isInterrupted());
        System.out.println("zzzzzzzz");
    }

}
