package leetcode;

import basic.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) fast = fast.next;
            if (fast == null) {
                ListNode temp = slow.next;
                slow.next = null;
                slow = temp;
            } else {
                slow = slow.next;
            }
        }
        slow = reverse(slow);
        ListNode cur = head;
        while (slow != null) {
            ListNode temp1 = cur.next, temp2 = slow.next;
            cur.next = slow;
            slow.next = temp1;
            cur = temp1;
            slow = temp2;
        }
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode res = null, remind = node, temp;
        while (remind != null) {
            temp = remind.next;
            remind.next = res;
            res = remind;
            remind = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, 2, 3, 4);
        new Solution0143().reorderList(node);
        System.out.println(node);

        node = new ListNode(1, 2, 3, 4, 5);
        new Solution0143().reorderList(node);
        System.out.println(node);
    }
}
