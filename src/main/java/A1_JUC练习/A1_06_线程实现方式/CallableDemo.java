package A1_JUC练习.A1_06_线程实现方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/25
 */

class Mythread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("-----------------------------------------------------");
        System.out.println(Thread.currentThread().getName());
        return 999;
    }
}

interface TestInterface extends Runnable{
    @Override
    void run();
}

public class CallableDemo {

    public static void main(String[] args) {

        //Thread(Runnable target, String name)  ,只能传入 Runnable 接口，那么我们只能传入 Runnable 接口的实现类或者 一个继承了Runnable接口的接口
        //分配一个新的 Thread对象。
//        Thread t1 = new Thread(new TestInterface(){
//            @Override
//            public void run() {
//            }
//        } ,"name");
        //public class FutureTask<V> implements RunnableFuture<V>
        //public interface RunnableFuture<V> extends Runnable, Future<V>

        //FutureTask 的构造方法   public FutureTask(Callable<V> callable)

        Mythread mythread = new Mythread();
        FutureTask futureTask = new FutureTask(mythread);
        FutureTask futureTask2 = new FutureTask(mythread);
        new Thread(futureTask , "A").start();
        new Thread(futureTask2 , "B").start();

        try {
            while(!futureTask.isDone()){
            }
            // 获取 Callable 线程的返回值 ， 如果没有运行完成就会阻塞，等待运行完成，才能获取结果
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
