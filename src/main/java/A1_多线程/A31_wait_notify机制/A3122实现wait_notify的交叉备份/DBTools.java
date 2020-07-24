package A1_多线程.A31_wait_notify机制.A3122实现wait_notify的交叉备份;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class DBTools {
    volatile private boolean prevIsA = false;
    synchronized public void backupA() { //同步方法对象锁  backupA  先执行
        try {
            while (prevIsA == true) {
                wait();
            }
            for (int i = 0; i < 5; i++) {  //备份a
                System.out.println("★★★★★");
            }
            prevIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void backupB() { //同步方法对象锁
        try {
            while (prevIsA == false) {
                wait();
            }
            for (int i = 0; i < 5; i++) { //开始备份b
                System.out.println("☆☆☆☆☆");
            }
            prevIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBTools dbtools = new DBTools();
        for (int i = 0; i < 20; i++) {
//            BackupB output = new BackupB(dbtools);
//            output.start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    dbtools.backupA();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    dbtools.backupB();
                }
            }).start();

//            BackupA input = new BackupA(dbtools);
//            input.start();
        }
    }

}
