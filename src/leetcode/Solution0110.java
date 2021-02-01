package leetcode;

import basic.TreeNode;

/*
110. 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：true

示例 2：
输入：root = [1,2,2,3,3,null,null,4,4]
输出：false

示例 3：
输入：root = []
输出：true

提示：
树中的节点数在范围 [0, 5000] 内
-10^4 <= Node.val <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/balanced-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0110 {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        getHigh(root);
        return flag;
    }

    private int getHigh(TreeNode node) {
        if (!flag) return -1;
        if (node == null) return 0;
        int left = getHigh(node.left);
        int right = getHigh(node.right);
        if (Math.abs(left - right) > 1) flag = false;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0110().isBalanced(new TreeNode(3, 9, 20, null, null, 15, 7)));
        System.out.println(new Solution0110().isBalanced(new TreeNode(1, 2, 2, 3, 3, null, null, 4, 4)));
        System.out.println(new Solution0110().isBalanced(null));
    }
}
