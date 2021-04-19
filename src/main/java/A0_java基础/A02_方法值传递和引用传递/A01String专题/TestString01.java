package A0_java基础.A02_方法值传递和引用传递.A01String专题;

import org.junit.Test;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/27
 * String是final类
 * String通过char数组来保存字符串
 * 对String对象的任何操作都不会影响到原来的String对象, 所有的改变都会创建新String对象
 */
public class TestString01 {
    @Test
    public void fun() {
        //创建方式
        //直接赋值，找常量池中是否存在aa，没有则在堆内存中的常量池中创建aa，则栈内存中的a直接指向常量池中的aa
        String a = "aa";
        //类初始化，这句一共生成了两个对象，分别是“aa” 和  new String("aa")，“aa"存放进常量池，堆内存中的 new String("aa") 指向常量池aa
        //栈内存中的a1直接指向堆内存中的new String("aa")
        String a1 = new String("aa");
        //内存地址不同，不相等
        System.out.println(a==a1);
        System.out.println("-----------------------------------------------------");



        //对象拼接
        //共创建了五个对象a , b 放进常量池 ， new String("a") ， new String("b")存在head堆内存中。还有一个对象是new String("a")+new String("b")也在堆内存
        String q = new String("a")+new String("b");


    }

    @Test
    public void fun2() {
        //+ 拼接
        // 当一个字符串由多个字符串常量连接而成时，它自己肯定也是字符串常量, 该字符串是在编译期就能确定。先是在池里生成“a”和“b”，再通过拼接的方式生成"ab"
        //所以常量池中存在a,b,ab
        String s1 = "a"+"b";
        //s2指向常量池中已经有的ab，则相等
        String s2 = "ab";
        System.out.println(s1==s2);

        //当变量和字符串相加时候，返回的一定是一个新的对象
        String ab = "ab";
        String b = "b";
        String ab2 = "a" + b;
        System.out.println((ab == ab2));

        //当变量和字符串相加时候，返回的一定是一个新的对象
        String a1 = "ab";
        final String bb1 = "b";
        String b1 = "a" + bb1;
        System.out.println((a1 == b1));

        System.out.println("-----------------------------------------------------");
    }

    @Test
    public void fun3() {
        //intern:返回一个新对象，让改对象指向常量池中的常量，如果常量池中不存在，则加入常量池

        // m -->  head堆内存中new String("mm") --》常量池中mm
        String m = new String("mm");
        //返回m2指向常量池中mm
        String m2 = m.intern();
        //n指向常量池中mm
        String n = "mm";

        System.out.println(n==m); //false
        System.out.println(n==m2); //true


        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;

        System.out.println(b.intern() == a);//false
        System.out.println(b.intern() == c);//true
        System.out.println(b.intern() == d);//true
        System.out.println(b.intern() == f);//false
        System.out.println(b.intern() == a.intern());//true

    }

    @Test
    public void fun4() {
        String a = new String("a");
        String b = "b";
        String ab = "ab";
        System.out.println(ab == a+b);
    }

}
