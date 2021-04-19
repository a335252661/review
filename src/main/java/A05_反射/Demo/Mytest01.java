package A05_反射.Demo;

import A05_反射.UserServiceImpl;
import C01_JVM.C01_01_双亲委派机制.Student;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/27
 */
public class Mytest01 {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        Class<? extends UserServiceImpl> aClass = userService.getClass();
        System.out.println(userService.getClass().getName());

        //第二种方式获取Class对象
        Class userClass = UserServiceImpl.class;
        System.out.println(aClass == userClass);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个


        //第三种方式获取Class对象
        try {
            Class usrClass = Class.forName("A05_反射.UserServiceImpl");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(usrClass == userClass);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
