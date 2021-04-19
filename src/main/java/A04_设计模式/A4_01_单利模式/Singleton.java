package A04_设计模式.A4_01_单利模式;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/8
 */
public class Singleton {
    static  Singleton singleton = null;
    private Singleton(){
    }
    public static  Singleton fun() {
        if(null==singleton){
            //当两个线程都判定为空，进来了，则就返回了两个对象，线程就不安全了
            singleton = new Singleton();
        }
        return singleton;
    }
    synchronized public static  Singleton fun2() {
        if(null==singleton){
            //当两个线程都判定为空，进来了，则就返回了两个对象，线程就不安全了
            singleton = new Singleton();
        }
        return singleton;
    }

}
