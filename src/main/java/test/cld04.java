package test;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/7
 */
public class cld04 {

    synchronized public void fun() {
        System.out.println(Thread.currentThread().getName()+  "synchronized public void fun");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fun2() {
        synchronized(this) {
            System.out.println(Thread.currentThread().getName()+"synchronized(this)");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void fun3() {
        synchronized(cld04.class) {
            System.out.println(Thread.currentThread().getName()+"synchronized(cld04.class) ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void fun4() {
        synchronized(new String()) {
            System.out.println(Thread.currentThread().getName()+"synchronized(new String())");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        cld04  cld04vo = new cld04();

        new Thread(new Runnable() {
            @Override
            public void run() {
                cld04vo.fun();
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cld04vo.fun2();
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cld04vo.fun3();
            }
        },"C").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cld04vo.fun4();
            }
        },"D").start();


    }


}
