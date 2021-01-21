package leetcode;

import basic.ListNode;

import java.util.Arrays;

/*
23. 合并K个升序链表
给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。

示例 1：
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6

示例 2：
输入：lists = []
输出：[]

示例 3：
输入：lists = [[]]
输出：[]
 
提示：
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start >= end) return null;
        if (start + 1 == end) return lists[start];
        int mid = (start + end) >>> 1;
        return mergeTwoList(mergeKLists(lists, start, mid), mergeKLists(lists, mid, end));
    }

    private ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
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
                temp.next = new ListNode(a.val);
                a = a.next;
            } else {
                temp.next = new ListNode(b.val);
                b = b.next;
            }
            temp = temp.next;
        }
        return res.next;
    }

    private ListNode mergeTwoList1(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val < b.val) return new ListNode(a.val, mergeTwoList(a.next, b));
        return new ListNode(b.val, mergeTwoList(a, b.next));
    }

    public static void main(String[] args) {
        System.out.println(new Solution0023().mergeKLists(new ListNode[]{
                new ListNode(1, 4, 5),
                new ListNode(1, 3, 4),
                new ListNode(2, 6)}));
    }
}
