package AllSorts;

import util.ArrUtil;


/**
 * @ProjectName: leetCode
 * @Package: AllSorts
 * @ClassName: inserSort
 * @Author: JamZhang
 * @Description: ${从未排序序列依次选数插入到已排序序列合适位置，初始时第一个数为默认已排序序列}
 * @Date: 2020/11/12 10:24
 * @Version: 1.0
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) ArrUtil.mySwap(arr, j, j - 1);
                else break;
            }
        }
    }
}
