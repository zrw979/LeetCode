package AllSorts;

import util.ArrUtil;
import java.util.Date;

/**
 * @ProjectName: leetCode
 * @Package: AllSorts
 * @ClassName: MainTest
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/11/12 9:30
 * @Version: 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        int[] arr = ArrUtil.getRandomArr(1000, 1000);
        ArrUtil.showArr(arr);
        long time1 = new Date().getTime();
        QuickSort.quickSort5(arr, 0, arr.length - 1);
        //SelectSort.selectSort(arr);
        //InsertSort.insertSort(arr);
        //ShellSort.shellSort(arr);
        long time2 = new Date().getTime();
        ArrUtil.showArr(arr);
        System.out.println(checkSort(arr));
        System.out.println((time2 - time1) + "ms");
    }

    public static boolean checkSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}
