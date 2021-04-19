package JDK18.Lambda.A06_Stream的使用.A04有状态操作;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/1/2
 */
public class Test05 {

    public static int[] arr;

    @BeforeAll
    public static void init() {
        arr = new int[5000000];  //5亿个随机Int
        randomInt(arr);
    }

    @JunitPerfConfig( warmUp = 1000, reporter = {HtmlReporter.class})
    public void testIntFor() {
        minIntFor(arr);
    }

    @JunitPerfConfig( warmUp = 1000, reporter = {HtmlReporter.class})
    public void testIntParallelStream() {
        minIntParallelStream(arr);
    }

    @JunitPerfConfig( warmUp = 1000, reporter = {HtmlReporter.class})
    public void testIntStream() {
        minIntStream(arr);
    }

    private int minIntStream(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }

    private int minIntParallelStream(int[] arr) {
        return Arrays.stream(arr).parallel().min().getAsInt();
    }

    private int minIntFor(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int anArr : arr) {
            if (anArr < min) {
                min = anArr;
            }
        }
        return min;
    }

    private static void randomInt(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
    }

}
