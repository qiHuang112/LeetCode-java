package leetcode;

import basic.ListNode;

/*
148. 排序链表
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

进阶：
你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 
示例 1：
输入：head = [4,2,1,3]
输出：[1,2,3,4]

示例 2：
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]

示例 3：
输入：head = []
输出：[]

提示：
链表中节点的数目在范围 [0, 5 * 10^4] 内
-10^5 <= Node.val <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == null) {
                ListNode temp = slow.next;
                slow.next = null;
                slow = temp;
            } else {
                slow = slow.next;
            }
        }
        return merge(sortList(slow), sortList(head));
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode res = new ListNode(0), temp = res;
        while (a != null || b != null) {
            if (a == null) {
                temp.next = b;
                break;
            }
            if (b == null) {
                temp.next = a;
                break;
            }
            if (a.val < b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0148().sortList(new ListNode(4, 2, 1, 3)));
        System.out.println(new Solution0148().sortList(new ListNode(-1, 5, 3, 4, 0)));
    }
}
