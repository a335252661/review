package C01_JVM.C01_01_双亲委派机制;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/26
 */
public class Student {

    public static void main(String[] args) {
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();  //public final native Class<?> getClass();
        System.out.println(aClass.getClassLoader()); //sun.misc.Launcher$AppClassLoader@18b4aac2
//        ClassLoader
    }

}
