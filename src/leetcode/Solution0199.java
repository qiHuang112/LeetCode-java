package leetcode;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res, int index) {
        if (node == null) return;
        if (res.size() == index) {
            res.add(node.val);
        } else {
            res.set(index, node.val);
        }
        dfs(node.left, res, index + 1);
        dfs(node.right, res, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0199().rightSideView(new TreeNode(1, 2, 3, null, 5, null, 4)));
    }
}
