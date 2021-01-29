package leetcode;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层序遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
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
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0102().levelOrder(new TreeNode(3, 9, 20, null, null, 15, 7)));
    }
}
