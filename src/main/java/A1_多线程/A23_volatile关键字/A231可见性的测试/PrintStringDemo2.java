package A1_多线程.A23_volatile关键字.A231可见性的测试;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 */
public class PrintStringDemo2 implements Runnable {
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
    @Override
    public void run() {
        printStringMethod();
    }

    public static void main(String[] args) {
        PrintStringDemo2 printStringService = new PrintStringDemo2();
        new Thread(printStringService).start();

        System.out.println("我要停止它！stopThread="
                + Thread.currentThread().getName());

        printStringService.setContinuePrint(false);
    }

}
