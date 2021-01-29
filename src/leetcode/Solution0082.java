package leetcode;

import basic.ListNode;

/*
82. 删除排序链表中的重复元素 II
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:
输入: 1->2->3->3->4->4->5
输出: 1->2->5

示例 2:
输入: 1->1->1->2->3
输出: 2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            ListNode temp = head.next;
            while (temp != null && temp.val == head.val) {
                temp = temp.next;
            }
            return deleteDuplicates(temp);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0082().deleteDuplicates(new ListNode(1, 2, 3, 3, 4, 4, 5)));
        System.out.println(new Solution0082().deleteDuplicates(new ListNode(1, 1, 1, 2, 3)));
    }
}
