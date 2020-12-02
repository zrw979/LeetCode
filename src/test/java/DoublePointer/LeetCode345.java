package DoublePointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ProjectName: leetCode
 * @Package: DoublePointer
 * @ClassName: LeetCode345
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/17 14:10
 * @Version: 1.0
 */

/*
345. Reverse Vowels of a String (Easy)

Leetcode / 力扣

Given s = "leetcode", return "leotcede".


使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。

为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。

时间复杂度为 O(N)：只需要遍历所有元素一次
空间复杂度 O(1)：只需要使用两个额外变量

 */
public class LeetCode345 {

    private final static HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        System.out.println(test345("leetcode"));
    }

    public static String test345(String s) {
        if (s == null || s == "") return null;
        char[] chars = new char[s.length()];
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail) {
            char i = s.charAt(head), j = s.charAt(tail);
            if (vowels.contains(i)) {
                if (vowels.contains(j)) {
                    chars[head] = j;
                    chars[tail] = i;
                    head++;
                    tail--;
                } else {
                    chars[tail] = j;
                    tail--;
                }

            } else {
                chars[head] = i;
                head++;
            }
        }
        return new String(chars);//String.valueOf(chars);
    }

    /**
     * reference answer
     */
    public static String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

}
