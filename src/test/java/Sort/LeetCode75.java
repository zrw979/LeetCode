package Sort;

import util.ArrUtil;

import java.util.Date;
import java.util.Random;

/**
 * @ProjectName: leetCode
 * @Package: Sort
 * @ClassName: LeetCode75
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/11/9 10:48
 * @Version: 1.0
 */
/*
75. Sort Colors (Medium)

Leetcode / 力扣

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
题目描述：只有 0/1/2 三种颜色。
 */
public class LeetCode75 {
    public static void main(String[] args) {
        int[] nums = getRandom(20);
        ArrUtil.showArr(nums);
        sortColors(nums);
        //mySortColors(nums);
        ArrUtil.showArr(nums);
    }


    /*
    设置两个变量r1,r2，含义是r1,左边(包含r1)的变量值都小于1，r2左边(包含r2)的变量值都小于2。

    那么初始时他俩都是-1(实际上是左边界-1)，代表他俩所包裹的范围是空。

    假设现在有数组nums = [0,0,1,1,2,0,0],r1 = 1,r2 = 3。下一个数组索引i是5，也就是要处理0，这个数是小于2的。

    因此r2+1，代表区间扩大，把nums[i]和nums[r2]交换。此时维持了r2左侧的数都是小于2的这个性质。

    交换完之后，这个小于2的数存放在了nums[r2]，但是这个nums[r2]仍然有可能小于1，若是小于1，那么

    应该把r1+1，代表区间扩大，然后把nums[r1]和nums[r2]交换，这样才能维持r1左侧的数小于1的这个性质。
    */
    private static void sortColors(int[] nums) {
        //代表初始所包裹范围为空
        int r1 = -1, r2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 2) {
                r2++;
                mySwap(nums, i, r2);
                if (nums[r2] < 1) {
                    r1++;
                    mySwap(nums, r1, r2);
                }
            }
        }
    }

    private static void mySortColors(int[] nums) {
        int i = 0, j = 1, k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == 0) {
                mySwap(nums, i, j);
                i++;
            } else if (nums[j] == 1) {
                j++;
            } else {
                mySwap(nums, j, k);
                k--;
            }
        }
        System.out.println(i + " " + j + " " + k);
    }

    public static void mySwap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int[] getRandom(int length) {
        int[] nums = new int[length];
        Random r = new Random(new Date().getTime());
        for (int i = 0; i < length; i++) {
            nums[i] = r.nextInt(3);
        }
        return nums;
    }

}
