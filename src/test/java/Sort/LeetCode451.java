package Sort;

import util.ArrUtil;
import util.StrUtil;

import java.util.*;

/**
 * @ProjectName: leetCode
 * @Package: Sort
 * @ClassName: LeetCode451
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/11/9 9:25
 * @Version: 1.0
 */

/*
451. Sort Characters By Frequency (Medium)

Leetcode / 力扣

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
(区分大小写)
 */

public class LeetCode451 {
    public static void main(String[] args) {
        String str = StrUtil.getRandomLetterStr(20);
        System.out.println(sortStr(str));
        System.out.println(frequencySort(str));
    }

    private static String sortStr(String str) {
        Map<Character, Integer> frequencyMap = new HashMap();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry> entryList = new ArrayList<>();
        frequencyMap.entrySet().forEach((entry) -> entryList.add(entry));
        entryList.sort((o1, o2) -> (int) o2.getValue() - (int) o1.getValue());

        String resStr = "";
        for (Map.Entry e : entryList) {
            for (int i = 0; i < (int) e.getValue(); i++) {
                resStr += e.getKey();
            }
        }
        return resStr;
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray())
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);

        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
