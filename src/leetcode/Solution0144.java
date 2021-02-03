package leetcode;

import basic.ListNode;
import basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

示例 1：
输入：root = [1,null,2,3]
输出：[1,2,3]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]

示例 4：
输入：root = [1,2]
输出：[1,2]

示例 5：
输入：root = [1,null,2]
输出：[1,2]

提示：
树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100

进阶：递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root != null) list.addLast(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeLast();
            res.addLast(node.val);
            if (node.right != null) list.addLast(node.right);
            if (node.left != null) list.addLast(node.left);
        }
        return res;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        dfs(res, root.left);
        dfs(res, root.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0144().preorderTraversal(new TreeNode(1, null, 2, 3)));
        System.out.println(new Solution0144().preorderTraversal(new TreeNode(1)));
        System.out.println(new Solution0144().preorderTraversal(new TreeNode(1, 2)));
        System.out.println(new Solution0144().preorderTraversal(new TreeNode(1, null, 2)));
        System.out.println(new Solution0144().preorderTraversal(new TreeNode(3, 9, 20, null, null, 15, 7)));
        System.out.println(new Solution0144().preorderTraversal1(new TreeNode(1, 2, 3, 4, 5, 6, 7)));
    }
}
