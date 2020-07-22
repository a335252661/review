package A1_多线程.A22synchronized同步语句块.A2224锁对象不改变依然同步执行;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 *
 * 对象锁 对象的属性改变，对象锁不会变，还是同一把锁
 */
public class Service2224 {
    public void serviceMethodA(Userinfo userinfo) {
        synchronized (userinfo) {
            try {
                System.out.println(Thread.currentThread().getName());
                userinfo.setName("abcabcabc");
                Thread.sleep(3000);
                System.out.println("end! time=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Service2224 service = new Service2224();
            Userinfo userinfo = new Userinfo();

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    service.serviceMethodA(userinfo);
                }
            },"T1");



            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    service.serviceMethodA(userinfo);
                }
            },"T2");

            t1.start();
            Thread.sleep(50);
            t2.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
