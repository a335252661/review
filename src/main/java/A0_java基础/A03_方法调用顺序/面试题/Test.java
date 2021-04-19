package A0_java基础.A03_方法调用顺序.面试题;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/27
 */

public class Test {
    public static void main(String[] args) {
        new SubClass();                                   // 0
    }
}

class SuperClass {

    int a = method();                                      //7    16
    static int b = show();                                 // 1

    private static int show() {
        System.out.println("父类的静态变量直接显示初始化");    //2
        return 0;
    }

    private int method() {
        System.out.println("父类的实例变量直接显示初始化");   //8  17
        return 0;
    }

    public SuperClass() {

        System.out.println("父类的无参构造器");             //10  19
    }

    {
        System.out.println("父类的构造代码块");             //9  18
    }

    static {
        System.out.println("父类的静态代码块");             //3
    }
}

class SubClass extends SuperClass {
    int a = method();                                     //11  20
    static int b = show();                                //4
    static SubClass sc = new SubClass();                  //6

    private static int show() {
        System.out.println("子类的静态变量直接显示初始化");   //5
        return 0;
    }

    private int method() {
        System.out.println("子类的实例变量直接显示初始化");  //12  21
        return 0;
    }

    public SubClass() {
        super();
        //..............
        System.out.println("子类的无参构造器");            //14  23
    }

    {
        System.out.println("子类的构造代码块");            //13  22
    }

    static {
        System.out.println("子类的静态代码块");            //15
    }
}


