package leetcode;

import basic.ListNode;

/*
25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例：
给你这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5

说明：
你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        ListNode res = new ListNode(0);
        ListNode node = res;
        ListNode cur, tail;
        ListNode remind = head;
        for (int i = 0; i < size / k; i++) {
            cur = null;
            tail = remind;
            for (int j = 0; j < k; j++) {
                temp = remind.next;
                remind.next = cur;
                cur = remind;
                remind = temp;
            }
            node.next = cur;
            node = tail;
        }
        node.next = remind;
        return res.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0025().reverseKGroup(new ListNode(1, 2, 3, 4, 5), 2));
        System.out.println(new Solution0025().reverseKGroup(new ListNode(1, 2, 3, 4, 5), 3));
    }
}
