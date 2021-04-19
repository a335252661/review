package test;

import java.util.*;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/6
 */
public class cld03 {

    class inner{
        int a=2;
    }

    public void fun() {
        class inner{
            int a=2;
            HashMap map = new HashMap();  //public interface Map<K,V> {
            ArrayList list  = new ArrayList();
            HashSet set= new HashSet();
            TreeSet set2 = new TreeSet();
            LinkedHashSet set3 = new LinkedHashSet();
        }
    }

    {
        class  inn3{
        }
    }

}
