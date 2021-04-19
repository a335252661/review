package A0_java基础.A02_方法值传递和引用传递;

import A1_多线程.A23_volatile关键字.A233禁止代码重排序的测试.Test2;
import org.junit.Test;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/27
 *值传递：传递的是基本数据类型
 * 引用传递：传递的是对象
 * 传递过去的都是新的拷贝
 *
 * 方法得到的参数值是一个拷贝，
 * 方法不能修改传递给他的任何参数的 变量 的内容
 * 一个方法不能修改一个基本数据类型的参数
 * 1、基本数据类型，作为入参是值传递，传递过去的是值的拷贝，拷贝的对象和原始对象指向的是不同的内存地址，方法体做数据修改，则原始变量值不变
 * 2、对象类型，作为入参是对象引用，传递过去的是对象的拷贝，拷贝的对象和原始对象指向的是同一个内存地址，方法体做对象修改，则原始对象也会改变
 * 3、对象类型，作为入参是对象引用，传递过去的是对象的拷贝，拷贝的对象和原始对象指向的是同一个内存地址，方法体对对象的指向做修改，则
 * 方法体内拷贝的对象的指向变了，原始对象的指向不会改变
 * 4、对象类型，注意，引用传递时候，如果传递的对象是被final修饰的，那么方法体内，对象的拷贝对进行属性的修改的时候，会重新创建一个新的对象
 * 对象的拷贝指向新的对象，原始对象指向旧的对象，原始对象不改变
 */
public class TestFun01 {
    public static void main(String[] args) {
        System.out.println("一个方法不能修改一个基本数据类型的参数");
        int num1 = 10;
        int num2 = 20;
        swap(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("例子2");
        System.out.println("-----------------------------------------------------");
        UserVo vo = new UserVo("cld","110");
        fun(vo);
        System.out.println(vo);

        System.out.println("例子3");
        System.out.println("-----------------------------------------------------");
        System.out.println("方法体内修改的拷贝对象的指向，原始对象不会改变");
        UserVo vo2 = new UserVo("cld","110");
        fun2(vo2);
        System.out.println(vo2);

        System.out.println("例子4");
        System.out.println("-----------------------------------------------------");
        final UserVo vo3 = new UserVo("cld","110");
        fun(vo3);
        System.out.println(vo3);
    }
    //对值进行交换
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void fun(UserVo vo) {
        vo.setName("zhansgan");
        System.out.println(vo);
    }

    public static void fun2(UserVo vo) {
        UserVo newvo = new UserVo("我是新的对象" ,"120");
        vo = newvo;
    }


    //面试题
    @Test
    public void fun() {
        String str = new String("good");
        String str1 = "wtf";
        int a = 10;
        char[] ch = { 'a', 'b', 'c' };

        change(str, str1, ch, a);
        System.out.println(str);//"good"
        System.out.println(str1);//"change ok"
        System.out.println(a); //10
        System.out.println(ch);//gbc

    }
    public void change(String str, String str1, char[] ch, int a) {
        str = new String("change ok");

        //引用传递，传递对象的拷贝，和原始对象指向相同的内存地址，现在对象的拷贝重新赋值了，1、在内存中创建了一个新的"change ok"，然后
        //对象的拷贝指向新的"change ok"？ 还是对象的拷贝直接修改了所指向的内存中的数据呢？。String比较特殊，他是final修改的，内存中的
        //数据不会内修改，只会被新建，所以属于我们的情况3，原始对象的指向还是"wtf"。
        str1 = "change ok";
        ch[0] = 'g';
        a = 13;
    }

}
