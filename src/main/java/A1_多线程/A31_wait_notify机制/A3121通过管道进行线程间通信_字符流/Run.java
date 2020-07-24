package A1_多线程.A31_wait_notify机制.A3121通过管道进行线程间通信_字符流;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 */
public class Run {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedReader inputStream = new PipedReader();
            PipedWriter outputStream = new PipedWriter();
// inputStream.connect(outputStream);
            outputStream.connect(inputStream);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    readData.readMethod(inputStream);
                }
            }).start();

            Thread.sleep(2000);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    writeData.writeMethod(outputStream);
                }
            }).start();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
