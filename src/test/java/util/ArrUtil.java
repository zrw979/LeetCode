package util;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @ProjectName: leetCode
 * @Package: util
 * @ClassName: arrUtil
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/24 11:58
 * @Version: 1.0
 */
public class ArrUtil {
    /**
     * 从arr1数组的index下标处开始，添加arr2数组的所有元素。
     * @param arr1
     * @param arr2
     * @param index
     * @return
     */
    public static int[] addArrFromIndex(int[] arr1, int[] arr2, int index) {
        for (int i = 0; i < arr2.length; i++) {
            if (index > arr1.length - 1) return null;
                arr1[index++] = arr2[i];
        }
        return arr1;
    }

    /**
     * 获取长度为len,元素值为0~x-1的随机整数数组
     */
    public static int[] getRandomArr(int len,int x){
        int[] arr = new int[len];
        Random r = new Random(new Date().getTime());
        for (int i = 0; i < len; i++) {
            arr[i] = r.nextInt(x)+1;
        }
        return arr;
    }

    /**
     * 控制台输出数组
     */
    public static void showArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换数组元素
     */
    public static void mySwap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
