package DoublePointer;

import bean.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: leetCode
 * @Package: DoublePointer
 * @ClassName: LeetCode141
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/9/24 14:13
 * @Version: 1.0
 */
/*
6. 判断链表是否存在环
141. Linked List Cycle (Easy)

Leetcode / 力扣

使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 */
public class LeetCode141 {

    public static void main(String[] args) {
        ListNode[] arr = new ListNode[10];
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode();
            node.setNodeValue(String.valueOf(i));
            arr[i] = node;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i].setNodeValue(String.valueOf(i));
            if (i != arr.length - 1) arr[i].setSuf(arr[i + 1]);
        }
        arr[arr.length - 1].setSuf(arr[0]);
        System.out.println(hasCycle(arr[0]));
    }

    public static boolean hasCycle(ListNode node) {
        if (node.getSuf() == null) return false;
        ListNode slow = node;
        ListNode fast = node;
        int count = 0;
        while (fast.getSuf() != null && fast.getSuf().getSuf() != null) {
            slow = slow.getSuf();
            fast = fast.getSuf().getSuf();
            count++;
            if (slow == fast) {
                System.out.println(count);
                return true;

            }
        }
        return false;
    }
}
