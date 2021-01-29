package leetcode;

import basic.TreeNode;

/*
104. 二叉树的最大深度
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0104 {
    int res = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        dfs(node.left, level + 1);
        res = Math.max(res, level);
        dfs(node.right, level + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0104().maxDepth(new TreeNode(3, 9, 20, null, null, 15, 7)));
        System.out.println(new Solution0104().maxDepth(null));
        System.out.println(new Solution0104().maxDepth(new TreeNode(1)));
    }
}
