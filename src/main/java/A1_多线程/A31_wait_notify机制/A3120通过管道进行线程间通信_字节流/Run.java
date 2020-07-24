package A1_多线程.A31_wait_notify机制.A3120通过管道进行线程间通信_字节流;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/24
 *
 * 首先读取线程new
 * ThreadRead（inputStream）启动，由于当时没有数据
 * 被写入，所以线程阻塞在“int
 * readLength=in.read（byteArray）；”代码中，直到有
 * 数据被写入，才继续向下运行。
 */
public class Run {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();
// inputStream.connect(outputStream);
            outputStream.connect(inputStream);


//            ThreadRead threadRead = new ThreadRead(readData, inputStream);
//            threadRead.start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readData.readMethod(inputStream);
                }
            }).start();

            Thread.sleep(2000);

//            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
//            threadWrite.start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    writeData.writeMethod(outputStream);
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
