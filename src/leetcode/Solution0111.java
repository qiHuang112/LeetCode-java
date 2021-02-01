package leetcode;

import basic.TreeNode;

/*
111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：2

示例 2：
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5

提示：
树中节点数的范围在 [0, 10^5] 内
-1000 <= Node.val <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0111 {
    int res = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode node, int height) {
        if (node == null || height > res) return;
        if (node.left == null && node.right == null) {
            res = height;
            return;
        }
        dfs(node.left, height + 1);
        dfs(node.right, height + 1);
    }


    public static void main(String[] args) {
        System.out.println(new Solution0111().minDepth(new TreeNode(3, 9, 20, null, null, 15, 7)));
        System.out.println(new Solution0111().minDepth(new TreeNode(2, null, 3, null, 4, null, 5, null, 6)));
    }
}
