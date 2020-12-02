package AllSorts;

import util.ArrUtil;

import java.util.Arrays;

/**
 * @ProjectName: leetCode
 * @Package: AllSorts
 * @ClassName: MergeSort
 * @Author: JamZhang
 * @Description: ${双指针，对两个有序数组从头比较放入新数组}
 * @Date: 2020/10/30 10:54
 * @Version: 1.0
 */
public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        if (arr == null) return null;
        if (arr.length < 2) {
            return arr;
        }
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        int mid = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arrCopy, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arrCopy, mid, arr.length);
        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        final int len1 = arr1.length;
        final int len2 = arr2.length;
        int[] arr3 = new int[len1 + len2];
//        ArrayList arr3 = new ArrayList();
        int index1 = 0, index2 = 0, index3 = 0;
        while (index1 <= len1 - 1 && index2 <= len2 - 1) {
            if (arr1[index1] < arr2[index2]) arr3[index3++] = arr1[index1++];
            else arr3[index3++] = arr2[index2++];
        }
        if (index1 == len1) {
            int[] ints = Arrays.copyOfRange(arr2, index2, len2);
            return ArrUtil.addArrFromIndex(arr3, ints, index3);
        } else if (index2 == len2) {
            int[] ints = Arrays.copyOfRange(arr1, index1, len1);
            return ArrUtil.addArrFromIndex(arr3, ints, index3);
        } else return null;
    }
}
