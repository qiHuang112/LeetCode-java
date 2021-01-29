package leetcode;

import basic.ListNode;

/*
83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:
输入: 1->1->2
输出: 1->2

示例 2:
输入: 1->1->2->3->3
输出: 1->2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) return deleteDuplicates(head.next);
        head.next = deleteDuplicates(head.next);
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            ListNode temp = head.next;
            while (temp != null && temp.val == head.val) {
                temp = temp.next;
            }
            head.next = deleteDuplicates1(temp);
        } else {
            head.next = deleteDuplicates1(head.next);
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0083().deleteDuplicates(new ListNode(1, 1, 2)));
        System.out.println(new Solution0083().deleteDuplicates(new ListNode(1, 1, 2, 3, 3)));
        System.out.println(new Solution0083().deleteDuplicates(new ListNode(1, 2, 2, 3, 3)));
    }
}
