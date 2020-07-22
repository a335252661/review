package A1_多线程.A23volatile关键字.A231可见性的测试;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 */
public class PrintString {
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
        PrintString printStringService = new PrintString();
        printStringService.printStringMethod();
        System.out.println("我要停止它！stopThread="
                + Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }

}
