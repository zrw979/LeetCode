package DoublePointer;

import java.util.*;

/**
 * @ProjectName: leetCode
 * @Package: DoublePointer
 * @ClassName: LeetCode524
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/24 14:58
 * @Version: 1.0
 */
/*
7. 最长子序列
524. Longest Word in Dictionary through Deleting (Medium)

Leetcode / 力扣

Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output:
"apple"
题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。

通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 */
public class LeetCode524 {
    public static void main(String[] args) {
        String[] strs = {"ale", "apple", "monkey", "plea", "abpcp", "appea"};
        List<String> strings = new ArrayList<String>(Arrays.asList(strs));
        String string = "abpcplea";
        List<String> longestWord = findLongestWord(strings, string);
        System.out.println(longestWord);
        longestWord.sort((o1, o2) -> o2.length() - o1.length());
        if (!longestWord.isEmpty()) {
            int length = longestWord.get(0).length();
            ArrayList<String> list = new ArrayList<>();
            //获取同长度子串
            for (String s : longestWord) {
                if (s.length() == length) list.add(s);
                else break;
            }
            //字典序排序
            Collections.sort(list);
            System.out.println(list.get(0));
        } else System.out.println("无满足条件结果");
        System.out.println(longestWord);
        System.out.println("string = " + string);
        System.out.println(strings);
    }

    public static List<String> findLongestWord(List<String> strings, String str) {
        List<String> list = new ArrayList<>();
        for (String s : strings) {
            int index = 0;
            String tmp = "";
            if (str.length() < s.length()) return null;
            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (s.charAt(index) == c) {
                    tmp += c;
                    index++;
                } else continue;
                if (index == s.length()) {
                    list.add(tmp);
                    break;
                }
            }
        }
        return list;
    }

    /**
     * reference answer
     */
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
