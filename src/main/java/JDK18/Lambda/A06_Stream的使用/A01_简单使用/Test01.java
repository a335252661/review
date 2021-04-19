package JDK18.Lambda.A06_Stream的使用.A01_简单使用;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/29
 */
public class Test01 {
    @Test
    public void fun() {

        //集合都可以这么操作
        List<String> dataLists = Arrays.asList("mml", "kend", "cld", "kenmo");

        List<String> kList = dataLists.stream()
                .filter(e -> e.startsWith("k"))      //获取k开头的字符串
                .map(String::toUpperCase)            //把这些字符转大写
                .sorted()
                .collect(Collectors.toList());//转化回集合

        kList.forEach(System.out::println);

        //数组转化为流  Stream.of()
        String[] str = {"mml", "kend", "cld", "kenmo"};
        String[] ks = Stream.of(str)
                .filter(e -> e.startsWith("k"))      //获取k开头的字符串
                .map(String::toUpperCase)            //把这些字符转大写
                .toArray(String[]::new);

        //文件转数据流
        Path path = Paths.get("file1.txt");
        try {
            Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
