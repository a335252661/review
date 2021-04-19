package A0_java基础.A04_接口和抽象类;

import A0_java基础.A01_基本数据类型.Test01;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/11
 */
public abstract class Test02 extends PersonService3 implements PersonService,PersonService2{

    public void fun() {

    }

    public  abstract void fun2();

    public Test02(){}

    public static void main(String[] args) {
//        Test02 test02 = new Test02();
    }

}
