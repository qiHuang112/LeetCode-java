package leetcode;

import basic.ListNode;
import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],
一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0109 {
    ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        node = head;
        return buildTreeNode(0, len);
    }

    /**
     * 先序遍历建树
     */
    private TreeNode buildTreeNode(int l, int r) {
        if (l >= r) return null;
        int m = (l + r) >>> 1;
        TreeNode root = new TreeNode();
        root.left = buildTreeNode(l, m);
        root.val = node.val;
        node = node.next;
        root.right = buildTreeNode(m + 1, r);
        return root;
    }

    public TreeNode sortedListToBST1(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        return getRes(arr, 0, arr.size() - 1);
    }

    private TreeNode getRes(List<Integer> arr, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) >>> 1;
        return new TreeNode(arr.get(mid), getRes(arr, l, mid - 1), getRes(arr, mid + 1, r));
    }

    public static void main(String[] args) {
        System.out.println(new Solution0109().sortedListToBST(new ListNode(-10, -3, 0, 5, 9)));
    }
}
