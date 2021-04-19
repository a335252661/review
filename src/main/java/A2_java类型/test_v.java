package A2_java类型;

/**
 * @author by test.cld
 * @date 2020/7/12  10:56
 * @description:
 *
 * 从例子上面就可以看出，参数是什么类型，返回值就是什么类型。不需要任何强制性转型就可以得到想要的类型。
 *
 * 这种用法的前提是：在返回值不明确的情况下，又想兼容多个返回类型的时候就可以采用这个方法了。
 *
 */
public class test_v {

    public static void main(String[] args) {
//        System.out.println(new test_v().fun(3L));

        float aFloat=new test_v().fun(1.2f);
        float aDouble=new test_v().fun(22L);


    }

    public <V> V fun(Object obj ){
        return (V)obj;

    }
}
