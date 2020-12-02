package AllSorts;

import util.ArrUtil;

/**
 * @ProjectName: leetCode
 * @Package: AllSorts
 * @ClassName: ShellSort
 * @Author: JamZhang
 * @Description: ${按gap间隔分成若干子数组分别运用插入排序，最后gap=1时相当于直接插入排序}
 * @Date: 2020/11/12 14:12
 * @Version: 1.0
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = 0; i < gap; i++) {
                gapInsertSort(i, gap, arr);
            }
            gap /= 2;
        }
    }

    public static void gapInsertSort(int start, int gap, int[] arr) {
        for (int i = start + gap; i < arr.length; i += gap) {
            for (int j = i; j >= gap; j -= gap) {
                if (arr[j] < arr[j - gap]) ArrUtil.mySwap(arr, j, j - gap);
                else break;
            }
        }
    }
}
