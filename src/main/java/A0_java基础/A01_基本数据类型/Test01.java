package A0_java基础.A01_基本数据类型;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 * 0、
 * 原码
 * 反码
 * 补码
 *
 * 1、为什么byte是-128 到127
 * 一个byte是一个字节，一个字节是八位，最高位是符号位，0表示正，1表示附负，
 * 所以最大的byte就是0111 1111 = 127
 * 最小的bute是1111 1111 = -127
 *
 * 3、        //short ， char 两个字节
 *         char c ='冲';
 *         //int ， flot 四个字节
 *         //long ， double 八个字节
 *         //boolen 一位 0/1
 *
 *4、
 * 大范围赋值给小范围的，需要强转，否则出现编译错误
 * 大范围和小范围运算，小范围会自动提升精度转化为大返回，最后结果也是大返回。
 */
public class Test01 {
    

    public static void main(String[] args) {
        byte aa = 127;
        aa+=5;
        System.out.println(aa);


        byte a1 = 2;
        byte a2 = 5;
        // 在进行 算数运算符 的时候，都会引发自动类型提升
        byte a3 = (byte) (a1 + a2);
        int a4 = a1+a2;


        byte a = 111;//-128  127
        byte b = 127;//-128  127


        System.out.println(a);
        System.out.println();

        // byte 一个字节  八位   00000000
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.parseInt("00001000",2));
        System.out.println(Integer.toBinaryString(123));  //1111011
        System.out.println(Integer.toBinaryString(172));  //1111011
        System.out.println(Integer.toBinaryString(97));  //1111011
//        System.out.println(1<<8);

        //short ， char 两个字节
        char c ='冲';
        //int ， flot 四个字节  float f = 3.4 这样会报错，3.4是双精度，大范围赋值给小返回需要强转
//        float f = 3.4;
        //long ， double 八个字节
        //boolen 一位 0/1


        //大范围和小范围运算，小范围会自动提升精度转化为大返回，最后结果也是大返回。(s1 + 1)就是int类型了，赋值给小返回强制转换
        System.out.println("大范围和小范围运算，小范围会自动提升精度转化为大返回，最后结果也是大返回。");
        short s1 = 1;
         s1 = (short)(s1 + 1);
        System.out.println(s1);
        // short s1 = 1; s1 +=1
        //对于short s1=1;s1+=1来说 +=是java语言规定的运算符，java编译器会对它进行特殊处理
        // （实际就是在     内部做了类型转化short s1 = 1; s1 +=1等价于short s1 = 1; s1=（short）s1+1），因此可以正确编译。
        short s3 = 1;
        s3 +=1;
        System.out.println(s3);


        System.out.println("-----------------------------------------------------");
        //小数默认就是double类型的，int类型和double类型运行，小范围的自动提升精度3 转化为 3.0 ，
        //但是double类型在进行计算的时候会出现误差，原因是
        //因为double类型和flot是以二进制形式储存的， 转换成十进制时只能做近似的转换，即使是一个确定值，他在做转换的时候也可能产生误差
        System.out.println(3 - 2.6);
        System.out.println(3.0 - 2.6);
        System.out.println(3 - 2.6 == 0.4);
        System.out.println(3.0 - 2.6 == 0.4);

        System.out.println(3f - 2f);
        System.out.println(3f - 2.1f);

        System.out.println("-----------------------------------------------------");
        //float f = 3.4; 直接编译报错，小数是浮点型double八个字节64位，float是四个字节16位，大范围赋值给小范围的需要强转
        //应该是float f = (double)3.4

    }
}
