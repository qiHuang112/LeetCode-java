package leetcode;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
107. 二叉树的层序遍历 II
给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层序遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.removeFirst();
                temp.add(node.val);
                if (node.left != null) list.addLast(node.left);
                if (node.right != null) list.addLast(node.right);
            }
            res.add(0, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0107().levelOrderBottom(new TreeNode(3, 9, 20, null, null, 15, 7)));
    }
}
