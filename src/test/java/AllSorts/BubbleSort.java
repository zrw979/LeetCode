package AllSorts;

import Sort.LeetCode75;
import util.ArrUtil;

/**
 * @ProjectName: leetCode
 * @Package: AllSorts
 * @ClassName: BubbleSort
 * @Author: JamZhang
 * @Description: ${每次选则最大或最小的数上顶或沉底}
 * @Date: 2020/11/11 14:29
 * @Version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = ArrUtil.getRandomArr(1000, 1000);
        ArrUtil.showArr(arr);
        bubbleSort(arr);
        ArrUtil.showArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) ArrUtil.mySwap(arr, j, j + 1);
            }
        }
    }
}
