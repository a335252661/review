package JDK18.Lambda.A03_简单练习;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 */
@FunctionalInterface
public interface MyInterface<T , R> {

    R getVal(T t1 , T t2);

}
