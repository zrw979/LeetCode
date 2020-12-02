package OtherTest;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @ProjectName: leetCode
 * @Package: OtherTest
 * @ClassName: TestArraysUtil
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/24 11:32
 * @Version: 1.0
 */
public class TestArraysUtil {
    @Test
    public void test() {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 4, 6};
        int[] arr3 = new int[4];
        System.out.println(Arrays.toString(arr3));
        ArrayList arrayList = new ArrayList();
        int index = 0;
        arrayList.add(arr1[index++]);
        System.out.println(arrayList.get(0) + "" + index);
        System.out.println(arrayList.addAll(1, Collections.singleton(arr1)));
        for (Object o : arrayList) {
            System.out.println(o);
        }
    }
}
