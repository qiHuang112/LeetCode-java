package leetcode;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root != null) list.addFirst(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeFirst();
            res.addFirst(node.val);
            if (node.left != null) list.addFirst(node.left);
            if (node.right != null) list.addFirst(node.right);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0145().postorderTraversal(new TreeNode(1, null, 2, 3)));
        System.out.println(new Solution0145().postorderTraversal(new TreeNode(1)));
        System.out.println(new Solution0145().postorderTraversal(new TreeNode(1, 2)));
        System.out.println(new Solution0145().postorderTraversal(new TreeNode(1, null, 2)));
        System.out.println(new Solution0145().postorderTraversal(new TreeNode(3, 9, 20, null, null, 15, 7)));
        System.out.println(new Solution0145().postorderTraversal(new TreeNode(1, 2, 3, 4, 5, 6, 7)));
    }
}
