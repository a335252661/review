package A1_多线程.线程安全.demo2;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/16
 * 本示例创建了两个业务对象，在系统中产生两
 * 个锁，线程和业务对象属于一对一的关系，每个线
 * 程执行自己所属业务对象中的同步方法，不存在争
 * 抢关系，所以运行结果是异步的，另外，在这种情
 * 况下，synchronized可以不需要，因为不会出现非线
 * 程安全问题。
 *
 * 则JVM会创建多
 * 个锁，不存在锁争抢的情况
 *
 * 另外，更具体地讲，
 * 由于本示例创建了两个业务对象，所以产生两份实
 * 例变量，每个线程访问自己的实例变量，所以加不
 * 加synchronized关键字都是线程安全的。
 */
public class HasSelfPrivateNumRun {
    public static void main(String[] args) {
        HasSelfPrivateNum numRefA = new HasSelfPrivateNum();
        HasSelfPrivateNum numRefB = new HasSelfPrivateNum();
        HasSelfPrivateNumA athread = new HasSelfPrivateNumA(numRefA);
        athread.start();
        HasSelfPrivateNumB bthread = new HasSelfPrivateNumB(numRefB);
        bthread.start();
    }
}
