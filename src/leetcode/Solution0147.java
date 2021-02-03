package leetcode;

import basic.ListNode;

/*
147. 对链表进行插入排序
对链表进行插入排序。
插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

插入排序算法：
插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。

示例 1：
输入: 4->2->1->3
输出: 1->2->3->4

示例 2：
输入: -1->5->3->4->0
输出: -1->0->3->4->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insertion-sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            insert(res, head.val);
            head = head.next;
        }
        return res.next;
    }

    private void insert(ListNode temp, int val) {
        while (temp.next != null && temp.next.val < val) {
            temp = temp.next;
        }
        temp.next = new ListNode(val, temp.next);
    }

    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = insertionSortList1(head.next);
        if (head.val <= node.val) {
            head.next = node;
            return head;
        }
        ListNode temp = node;
        while (temp.next != null && temp.next.val < head.val) {
            temp = temp.next;
        }
        head.next = temp.next;
        temp.next = head;
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0147().insertionSortList(new ListNode(4, 2, 1, 3)));
        System.out.println(new Solution0147().insertionSortList(new ListNode(-1, 5, 3, 4, 0)));
    }
}
