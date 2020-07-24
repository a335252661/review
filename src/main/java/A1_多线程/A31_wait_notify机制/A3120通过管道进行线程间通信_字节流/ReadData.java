package A1_多线程.A31_wait_notify机制.A3120通过管道进行线程间通信_字节流;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class ReadData {
    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("read :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(",读="+newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
