package AllSorts;

import util.ArrUtil;

/**
 * @ProjectName: leetCode
 * @Package: AllSorts
 * @ClassName: SelectSort
 * @Author: JamZhang
 * @Description: ${每次找到最大或最小数的数组下标，然后对上顶或沉底位置进行交换}
 * @Date: 2020/11/12 9:30
 * @Version: 1.0
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int tmp = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[tmp] > arr[j]) {
                    tmp = j;
                }
            }
            ArrUtil.mySwap(arr, i, tmp);
        }
    }
}
