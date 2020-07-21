package A1_多线程.A21synchronized同步方法.demo4;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 * 出现脏读是因为public void getValue()方法并不
 * 是同步的，所以可以在任意时刻进行调用，解决办
 * 法是加上同步synchronized关键字
 */
public class Test {
    public static void main(String[] args) {
        try {
            PublicVar publicVarRef = new PublicVar();
            ThreadA thread = new ThreadA(publicVarRef);
            thread.start();
            Thread.sleep(200);// 输出结果受此值大小影响
            publicVarRef.getValue();
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
