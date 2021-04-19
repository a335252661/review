package test;

import Helps.ListHelp;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/14
 */
public class cld {

    public static int count=0;

    public static void main(String[] args) {


        Object ob = new Object();

        String ss;


        cld cc = new cld();

        ListHelp.fast(3).forEach(i -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cc.fun();
                }
            },"T"+i).start();
        });


        while (true){
            if(count==3){
                System.out.println("所有现场结束");
            }
        }
    }

    public void fun(){
        try {
            Thread.sleep(10000);
            System.out.println("ee");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            synchronized (this){
                count++;
                System.out.println(count);
            }
        }
    }

}
