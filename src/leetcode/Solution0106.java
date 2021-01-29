package leetcode;

import basic.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。
例如，给出
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0106 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1) return null;
        TreeNode root = new TreeNode(postorder[r2]);
        int index = map.get(postorder[r2]);
        root.left = buildTree(inorder, l1, index - 1, postorder, l2, index - 1 - l1 + l2);
        root.right = buildTree(inorder, index + 1, r1, postorder, index - l1 + l2, r2 - 1);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }
}
