package leetcode;

import basic.TreeNode;

import java.util.Stack;

/*
173. 二叉搜索树迭代器
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
调用 next() 将返回二叉搜索树中的下一个最小的数。

示例：
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false
 
提示：
next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 这题也显得有点不大行，题意是想让我们用栈模拟出中序遍历的递归过程，
 * 从而让空间复杂度降低，但是直接中序遍历保存在数组中，反而有比最佳答案更优的速度，就很迷
 */
public class Solution0173 {
    static class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            leftMostInorder(root);
        }

        private void leftMostInorder(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                leftMostInorder(node.right);
            }
            return node.val;
        }

        public boolean hasNext() {
            return stack.size() > 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, 3, 15, null, null, 9, 20);
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next()); // 返回 3
        System.out.println(iterator.next()); // 返回 7
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 9
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 15
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 20
        System.out.println(iterator.hasNext()); // 返回 false
    }
}
