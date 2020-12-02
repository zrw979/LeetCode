package OtherTest;

import Sort.LeetCode75;
import bean.ListNode;
import org.junit.Test;
import util.ArrUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ProjectName: leetCode
 * @Package: OtherTest
 * @ClassName: Test
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/24 14:40
 * @Version: 1.0
 */
public class MyTest {

    public static void main(String[] args) {
        int[] arr = {1, 3333333, 233};
        System.out.println(method1(1, 3, arr));
    }

    @Test
    public void test1() {
        ListNode node = new ListNode();
        System.out.println(node == null);
        System.out.println(node.equals(null));
        System.out.println(node.getNodeValue() == null);
        System.out.println(node.getSuf() == null);
        System.out.println("-----------");
        System.out.println("asd".compareTo("zxsd"));
    }

    @Test
    public void test2() {
        long time = new Date().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateFormat.format(time));
    }

    public static String method1(int x, int y, int[] arr) {
        int res = method2(x, y, arr);
        return x + "+" + y + "=" + res + Arrays.toString(arr);
    }

    public static int method2(int x, int y, int[] arr) {
        x++;
        y++;
        arr[0] = 1111;
        return x + y;
    }

    @Test
    public void test3() {
        System.out.println(Arrays.toString(ArrUtil.getRandomArr(20, 20)));
        int[] nums = ArrUtil.getRandomArr(10, 10);
        ArrUtil.showArr(nums);
        int i = 0, j = 1;
        LeetCode75.mySwap(nums, i++, ++j);
        ArrUtil.showArr(nums);
        System.out.println(i + " " + j);
    }

    @Test
    public void test4() throws IOException {
        File f = new File("C:\\Users\\JamZhang\\Desktop\\zz.txt");
        FileReader fr = new FileReader(f);
        char[] cbuff = new char[6];
        while (fr.read(cbuff) != -1) {
            String s = String.valueOf(cbuff);
            //for (int i = 0; i < 16; i++) {
            System.out.println(s);
            //}
        }
        fr.close();
    }

    @Test
    public void test5() {
        int[] arr = ArrUtil.getRandomArr(20, 20);
        ArrUtil.showArr(arr);
    }
}
