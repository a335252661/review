package A1_多线程.A31_wait_notify机制.A314wait方法的基本使用;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/23
 *
 * 出现异常的原因是没有“对象监视器”，即没有
 * 锁。
 */
public class A1Test1 {
    public static void main(String[] args) {
        try {
            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
