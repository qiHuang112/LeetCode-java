package leetcode;

import basic.ListNode;
import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
95. 不同的二叉搜索树 II
给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

示例：
输入：3
输出：
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]

解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

提示：
0 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0095 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> l = generateTrees(left, i - 1);
            List<TreeNode> r = generateTrees(i + 1, right);
            for (TreeNode leftNode : l) {
                for (TreeNode rightNode : r) {
                    res.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0095().generateTrees(1));
        System.out.println(new Solution0095().generateTrees(2));
        System.out.println(new Solution0095().generateTrees(3));
    }
}
