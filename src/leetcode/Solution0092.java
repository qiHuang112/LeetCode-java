package leetcode;

import basic.ListNode;

/*
92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m > 1) {
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }
        ListNode res = null;
        ListNode remind = head;
        while (n-- > 0) {
            ListNode temp = remind.next;
            remind.next = res;
            res = remind;
            remind = temp;
        }
        head.next = remind;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0092().reverseBetween(new ListNode(1, 2, 3, 4, 5), 2, 4));
    }
}
