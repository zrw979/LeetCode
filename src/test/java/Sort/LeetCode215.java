package Sort;

import AllSorts.QuickSort;
import util.ArrUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetCode
 * @Package: Sort
 * @ClassName: LeetCode215
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/10/26 9:44
 * @Version: 1.0
 */

/*
215. Kth Largest Element in an Array (Medium)

        Leetcode / 力扣

        Input: [3,2,1,5,6,4] and k = 2
        Output: 5
        题目描述：找到倒数第 k 个的元素。
*/

public class LeetCode215 {

    public static void main(String[] args) {
        int k = 2;
        int[] arr1 = {3, 1, 9, 11, 4, 7};
        int[] arr2 = {};
        System.out.println(findKthLargest2(arr1, k));
    }

    //直接排序
    public static int findKthLargest1(int[] arr, int k) {
        int length = arr.length;
        if (k < 1 || k > length) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(arr);
        //QuickSort.quickSort5(arr, 0, arr.length - 1);
        return arr[length - k];
    }

    //使用堆
    public static int findKthLargest2(int[] arr, int k) {
        PriorityQueue queue = new PriorityQueue();
        for (int i: arr) {
            queue.add(i);
            if (queue.size()>k){
                queue.poll();
            }
        }
        return (int) queue.peek();
    }

    //快速选择
    /**
     * 略了
     */
}
