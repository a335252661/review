package A1_多线程.A23volatile关键字.A231可见性的测试;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 *
 * 是什么原因造成出现死循环呢？在启动
 * RunThread.java线程时，变量“private boolean
 * isRunning=true；”存在于公共堆栈及线程的私有堆栈
 * 中，线程运行后一直在线程的私有堆栈中取得的
 * isRunning的值是true，而代
 * 码“thread.setRunning（false）；”虽然被执行，更新
 * 的却是公共堆栈中的isRunning变量，改为了false，
 * 操作的是两块内存地址中的数据，所以线程一直处
 * 于死循环的状态
 *
 * 这个问题其实是私有堆栈中的值和公共堆栈中
 * 的值不同步造成的，解决这样的问题就要使用
 * volatile关键字了，其主要的作用是当线程访问
 * isRunning这个变量时，强制从公共堆栈中进行取
 * 值。
 *
 * 使用volatile关键字，可以增加实例变量在多个
 * 线程之间的可见性。
 */
public class RunThread extends Thread{
     private boolean isRunning = true;   //会出现死循环  线程被停止了！  永远不会执行
//    volatile private boolean isRunning = true;
    //对变量添加volatile关键字，当线程访问这个变量的时候强制从公共内崔中取值
    public boolean isRunning() {
        return isRunning;
    }
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning == true) {
            //synchronized (new Object()){};  //当线程碰到synchronized 关键字的时候，会将公共堆栈的数据同步到当前线程堆栈
        }
        System.out.println("线程被停止了！");
    }


    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();  //线程执行公共堆栈和线程私有堆栈isRunning = true
            Thread.sleep(1000);
            thread.setRunning(false);   //线程执行公共堆栈 isRunning 修改为false   ，线程私有堆栈依然是true，故线程被停止了！不会执行
            System.out.println("已经赋值为false");
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
