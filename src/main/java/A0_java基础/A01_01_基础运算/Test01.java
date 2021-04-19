package A0_java基础.A01_01_基础运算;

import org.junit.Test;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/8
 */
public class Test01 {

    public static void main(String[] args) {
        //局部变量表   ，   栈
        //解析
        // https://www.bilibili.com/video/BV1Eb411P7bP?spm_id_from=333.788.b_636f6d6d656e74.28
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }

    @Test
    public void fun() {
        int i = -5;
//        i =  ++(i++);
//        i =  ++(5);
        System.out.println(i);
    }

    @Test
    public void fun2() {
        int a = 10;
        int b = 10;
        System.out.println(a++);
        System.out.println(++b);
    }

    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);  //第一步，输出1
            return ++temp;             //第二步，temp=2 ， 保存起来，不返回   ，第五步，返回保存的temp=2
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;                     //第三步，temp=3
            System.out.println(temp);   //第四步，输出3
        }
    }
    @Test
    public void fun3() {
        System.out.println(test());    //第六步，输出2
    }

}
