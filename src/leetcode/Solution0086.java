package leetcode;

import basic.ListNode;

/*
86. 分隔链表
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。

示例：
输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0086 {
    public ListNode partition(ListNode head, int x) {
        ListNode res1 = new ListNode(0), res2 = new ListNode(0);
        ListNode temp = head, temp1 = res1, temp2 = res2;
        while (temp != null) {
            if (temp.val < x) {
                temp1.next = new ListNode(temp.val);
                temp1 = temp1.next;
            } else {
                temp2.next = new ListNode(temp.val);
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp1.next = res2.next;
        return res1.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0086().partition(new ListNode(1, 4, 3, 2, 5, 2), 3));
    }
}
