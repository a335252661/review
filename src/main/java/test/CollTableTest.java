package test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/7
 */
public class CollTableTest implements Callable<Long> {

    // ReentrantLock是Lock的唯一实现类
    Lock lock = new ReentrantLock();

    @Override
    public Long call() throws Exception {
        return 999L;
    }

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<Long> submit = executorService.submit(new CollTableTest());
//
//        try {
//            Long aLong = submit.get();
//            System.out.println(aLong);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


        System.out.println(3|9);
        System.out.println(3&9);

        System.out.println(3<<2); //11   -- 1100
        System.out.println(Integer.toBinaryString(12));
        System.out.println(3>>2);




        ExecutorService executorService = Executors.newCachedThreadPool();
        final  CollTableTest coll = new CollTableTest();


        for (int i = 0; i <20 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    coll.readFile("djsadqwoidjqowijaskcnjsakdjwo");
                }
            });
        }


    }

    public void readFile(String fileMessage){
        lock.lock();// 上锁
        try{
            System.out.println(Thread.currentThread().getName()+"得到了锁，正在读取文件……");
            for(int i=0; i<fileMessage.length(); i++){
                System.out.print(fileMessage.charAt(i));
            }
            System.out.println();
            System.out.println("文件读取完毕！");
        }finally{
            System.out.println(Thread.currentThread().getName()+"释放了锁！");
            lock.unlock();
        }
    }
}
