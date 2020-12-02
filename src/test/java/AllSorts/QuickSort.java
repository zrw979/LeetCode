package AllSorts;

import org.junit.Test;
import util.ArrUtil;

import java.util.Arrays;
import java.util.Date;

/**
 * @ProjectName: leetCode
 * @Package: AllSorts
 * @ClassName: QuickSort
 * @Author: JamZhang
 * @Description: ${最易理解的思路：挖坑填数}
 * @Date: 2020/10/26 14:40
 * @Version: 1.0
 */

/**
 * 快速排序：https://blog.csdn.net/morewindows/article/details/6684558
 * 时间复杂度：O(nlogn)
 * 空间复杂度：
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {11, 12, 1, 4, 55, 44};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int sentinelPos = getSentinelPos(arr, left, right);
            arr = quickSort(arr, left, sentinelPos - 1);
            arr = quickSort(arr, sentinelPos + 1, right);
        }
        return arr;
    }

    private static int getSentinelPos(int[] arr, int left, int right) {
        int sentinelVal = arr[left];
        int start = left + 1;
        int end = right;
        while (start < end) {
            while (start < end && arr[start] < sentinelVal) start++;
            while (start < end && arr[end] > sentinelVal) end--;
            if (start < end) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
            }
        }
        mySwap(arr, left, start - 1);
        return start - 1;
    }

    public static void mySwap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void quickSort1(int[] arr, int low, int high) {

        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

    @Test
    public void test3() {
        int[] arr = ArrUtil.getRandomArr(1000, 1000);
        //int[] arr = {8, 10, 14, 19, 4, 8, 16, 7, 4, 15, 18, 17, 13, 1, 17, 3, 17, 6, 15, 1};
        ArrUtil.showArr(arr);
        long start = new Date().getTime();
        quickSort5(arr, 0, arr.length - 1);
        long end = new Date().getTime();
        ArrUtil.showArr(arr);
        System.out.println("耗时" + (end - start) + "ms");
    }

    public static int[] quickSort4(int[] arr, int left, int right) {
        if (left < right) {
            //获取中轴元素所处的位置
            int mid = partition(arr, left, right);
            //进行分割
            arr = quickSort4(arr, left, mid - 1);
            arr = quickSort4(arr, mid + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //选取中轴元素
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            // 向右找到第一个小于等于 pivot 的元素位置
            while (i <= j && arr[i] <= pivot) i++;
            // 向左找到第一个大于等于 pivot 的元素位置
            while (i <= j && arr[j] >= pivot) j--;
            if (i > j)
                break;
            //交换两个元素的位置，使得左边的元素不大于pivot,右边的不小于pivot
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        arr[left] = arr[j];
        // 使中轴元素处于有序的位置
        arr[j] = pivot;
        return j;
    }


    //挖坑填数+分治法
    public static int[] quickSort5(int[] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int sentinelVal = arr[left];
            while (left < right) {
                while (arr[right] > sentinelVal && left < right) right--;
                if (left < right) arr[left++] = arr[right];
                while (arr[left] < sentinelVal && left < right) left++;
                if (left < right) arr[right--] = arr[left];
            }
            arr[left] = sentinelVal;
            quickSort5(arr, i, left - 1);
            quickSort5(arr, left + 1, j);
        }
        return arr;
    }

    void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

}

