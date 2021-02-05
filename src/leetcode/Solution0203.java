package leetcode;

import basic.ListNode;

/*
203. 移除链表元素
删除链表中等于给定值 val 的所有节点。

示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
public class Solution0203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return removeElements(head.next, val);
        head.next = removeElements(head.next, val);
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0203().removeElements(new ListNode(1, 2, 6, 3, 4, 5, 6), 6));
        System.out.println(new Solution0203().removeElements(new ListNode(6, 6, 1, 2, 6, 3, 4, 5, 6), 6));
    }
}
