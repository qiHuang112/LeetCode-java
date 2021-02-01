package leetcode;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Integer> temp = new LinkedList<>();
        temp.addLast(root.val);
        dfs(res, root, targetSum, root.val, temp);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode node, int targetSum, int cur, LinkedList<Integer> temp) {
        if (node.left == null && node.right == null) {
            if (cur == targetSum) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (node.left != null) {
            temp.addLast(node.left.val);
            dfs(res, node.left, targetSum, cur + node.left.val, temp);
            temp.removeLast();
        }
        if (node.right != null) {
            temp.addLast(node.right.val);
            dfs(res, node.right, targetSum, cur + node.right.val, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0113().pathSum(new TreeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
    }
}
