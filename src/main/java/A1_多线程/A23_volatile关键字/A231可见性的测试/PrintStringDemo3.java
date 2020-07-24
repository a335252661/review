package A1_多线程.A23_volatile关键字.A231可见性的测试;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 */
public class PrintStringDemo3 {
    private boolean isContinuePrint = true;
    public boolean isContinuePrint() {
        return isContinuePrint;
    }
    public void setContinuePrint(boolean isContinuePrint) {
        this.isContinuePrint = isContinuePrint;
    }
    public void printStringMethod() {
        try {
            while (isContinuePrint == true) {
                System.out.println("run printStringMethod threadName="
                        + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintStringDemo3 printStringDemo3 = new PrintStringDemo3();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                printStringDemo3.printStringMethod();
            }
        },"T1");
        thread.start();
        //线程开启 ， 就相当于一部操作，开启之后就不管了，直接执行后续语句

        System.out.println("我要停止它！stopThread="
                + Thread.currentThread().getName());

        printStringDemo3.setContinuePrint(false);

    }
}
