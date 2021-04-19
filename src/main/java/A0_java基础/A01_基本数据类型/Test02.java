package A0_java基础.A01_基本数据类型;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 *
 * Byte,Short,Integer,Long,Character,Boolean，实现了常量池， 默认创建了相应类型的缓存数据[-128 , 127]，超出数据大小则是新建的对象
 * Float Double 没有实现常量池技术
 *
 */
public class Test02 {
    public static void main(String[] args) {
//        Integer i1 = 33;
//        Integer i2 = 33;
//        System.out.println(i1 == i2);// 输出 true
//        Integer i11 = 333;
//        Integer i22 = 333;
//        System.out.println(i11 == i22);// 输出 false
//        Double i3 = 1.2;
//        Double i4 = 1.2;
//        System.out.println(i3 == i4);// 输出 false

        System.out.println("-----------------------------------------------------");
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2 " + (i1 == i2));//true

        //因为+操作法不适用于对象类型，则拆箱为int40+int0 = int40，最后得int40 ，
        // 对象类型无法和数值类型比较，则对象类型会被拆箱，i1  ==》 int40 ， 最后是int40比较int40
        System.out.println("i1=i2+i3 " + (i1 == i2 + i3));//true
        System.out.println("i1=i4 " + (i1 == i4));//false
        System.out.println("i4=i5 " + (i4 == i5));//false
        System.out.println("i4=i5+i6 " + (i4 == i5 + i6));//true
        System.out.println("40=i5+i6 " + (40 == i5 + i6));//true

        System.out.println("-----------------------------------------------------");
        System.out.println("对象类型和数值类型");
        Integer m1 = 40;
        Integer m2 = 255;
        Integer m3 = new Integer(255);
        Integer m4 = new Integer(40);
        int q1 = 40;
        int q2 = 255;
        System.out.println(m1 ==q1 ); // 对象类型无法和数值类型比较，则对象类型会被拆箱为int 40
        System.out.println(m2 ==q2 );
        System.out.println(m3 ==q2 );
        System.out.println(m3 ==m2 );//false
        System.out.println(m1 ==m2 );//false
        System.out.println(m1 ==m4 );//false

    }
}
