package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, k, 1, new LinkedList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int k, int index, LinkedList<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (index > n || k - temp.size() > n - index + 1) return;
        for (int i = index; i <= n; i++) {
            temp.addLast(i);
            dfs(res, n, k, i + 1, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0077().combine(4, 2));
        System.out.println(new Solution0077().combine(5, 2));
    }
}
