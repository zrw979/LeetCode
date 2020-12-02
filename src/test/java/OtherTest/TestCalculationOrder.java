package OtherTest;

import org.junit.Test;

/**
 * @ProjectName: leetCode
 * @Package: OtherTest
 * @ClassName: Test
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/18 14:37
 * @Version: 1.0
 */
public class TestCalculationOrder {
    @Test
    public void test() {
        String str = "ssfdsfdgfdgdgs";
        System.out.println(str.substring(3));
        System.out.println(str.substring(0, 3));
        char[] chars = str.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while (chars[head++] == chars[tail--]) {
            System.out.println(chars[head] + "" + chars[tail] + "-----");
        }
        System.out.println(chars[head] + "" + chars[tail]);

        int tmp = 1;
        System.out.println(chars[tmp + 1] == 'f');

        int[] arr = {1, 2, 3};
        int index = 0;
        arr[index++] = 7;
        System.out.println(index + " " + arr[0]);

        System.out.println("--------");
        String s1 = "123456", s2 = "367";
        int index1 = 0;
        System.out.println(s2.charAt(index1++) == s1.charAt(4));
        System.out.println(index1);
        /*
        for (char c : s1.toCharArray()) {
            if (s2.charAt(index1++) == c) continue;
        }
        */
    }
}
