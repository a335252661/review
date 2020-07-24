package A1_多线程.A31_wait_notify机制.A3121通过管道进行线程间通信_字符流;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class WriteData {
    public void writeMethod(PipedWriter out) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData);
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
