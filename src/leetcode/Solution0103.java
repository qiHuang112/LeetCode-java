package leetcode;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
103. 二叉树的锯齿形层序遍历
给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        boolean flag = true;
        while (!list.isEmpty()) {
            int size = list.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.removeFirst();
                if (flag) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) list.addLast(node.left);
                if (node.right != null) list.addLast(node.right);
            }
            flag = !flag;
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0103().zigzagLevelOrder(new TreeNode(3, 9, 20, null, null, 15, 7)));
    }
}
