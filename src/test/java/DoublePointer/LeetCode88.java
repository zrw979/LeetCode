package DoublePointer;

import org.junit.Test;
import util.ArrUtil;

import java.util.*;

/**
 * @ProjectName: leetCode
 * @Package: DoublePointer
 * @ClassName: LeetCode88
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/22 11:00
 * @Version: 1.0
 */


/*
88. Merge Sorted Array (Easy)

Leetcode / 力扣

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
题目描述：把归并结果存到第一个数组上。

需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
 */

//这题感觉出的差点意思，我写一下归并排序算法代替
public class LeetCode88 {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {4, 1, 6, 8, 3, 10, 88, 12};
        for (int i = 0; i < arr.length; i++) {
            Random r = new Random(new Date().getTime());
            Thread.sleep(10);
            arr[i] = r.nextInt(100);
        }
        System.out.println(Arrays.toString(mergeSort(arr)));
        int[] arr1 = null;
        System.out.println(mergeSort(arr1));
    }

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

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] copy = Arrays.copyOfRange(arr, 0, 3);
        for (int i : copy) {
            System.out.println(i);
        }
        int x = 5 / 2;
        System.out.println(x);
    }
}
