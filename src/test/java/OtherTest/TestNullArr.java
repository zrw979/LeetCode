package OtherTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: leetCode
 * @Package: OtherTest
 * @ClassName: TestNullArr
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/10/26 10:08
 * @Version: 1.0
 */
public class TestNullArr {
    @Test
    public void test1() {
        int[] arr1 = null;
        int[] arr2;
        int[] arr3 = new int[10];
        List list = new ArrayList<Integer>();
        System.out.println(Arrays.toString(arr3) + " " + arr1 + " " + list);
    }
}
