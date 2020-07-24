package A1_多线程.A31_wait_notify机制.A3120通过管道进行线程间通信_字节流;

import java.io.PipedOutputStream;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out){
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print("，写="+outData);
                Thread.sleep(10);
            }
            System.out.println();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
