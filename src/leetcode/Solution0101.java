package leetcode;

import basic.TreeNode;

/*
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 
进阶：
你可以运用递归和迭代两种方法解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && dfs(a.left, b.right) && dfs(a.right, b.left);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0101().isSymmetric(new TreeNode(1, 2, 2, 3, 4, 4, 3)));
        System.out.println(new Solution0101().isSymmetric(new TreeNode(1, 2, 2, null, 3, null, 3)));
    }
}
