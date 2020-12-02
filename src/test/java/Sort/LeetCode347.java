package Sort;

import util.ArrUtil;

import java.util.*;

/**
 * @ProjectName: leetCode
 * @Package: Sort
 * @ClassName: LeetCode347
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/10/30 14:17
 * @Version: 1.0
 */
/*
347. Top K Frequent Elements (Medium)

Leetcode / 力扣

Given [1,1,1,2,2,3] and k = 2, return [1,2].
设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。

把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
 */
public class LeetCode347 {
    public static void main(String[] args) {
        int[] arr = ArrUtil.getRandomArr(1000, 1000);
        ArrUtil.showArr(arr);
        Date date = new Date();

        long time0 = date.getTime();
        ArrUtil.showArr(topKFrequent(arr, 5));
        long time1 = date.getTime();
        System.out.println(time1 - time0);

        time0 = date.getTime();
        ArrUtil.showArr(getFrequentTopK(arr, 5));
        time1 = date.getTime();
        System.out.println(time1 - time0);
    }

    public static int[] getFrequentTopK(int[] nums, int k) {

        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = frequencyForNum.entrySet();
        //System.out.println(entries);
        List<Map.Entry> frequenceList = new ArrayList();
        for (Map.Entry entry : entries) {
            frequenceList.add(entry);
        }

        frequenceList.sort((o1, o2) -> (int) o2.getValue() - (int) o1.getValue());
        //System.out.println(frequenceList);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {

            Map.Entry entry = frequenceList.get(i);
            res[i] = (int) entry.getKey();
        }
        return res;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i);
        }
        return res;
    }

}
