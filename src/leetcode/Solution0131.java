package leetcode;

import java.util.*;

/*
131. 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。

示例:
输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0131 {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, dp, stack, res);
        return res;
    }

    private void dfs(String s, int index, boolean[][] dp, Deque<String> stack, List<List<String>> res) {
        if (index == dp.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < dp.length; i++) {
            if (!dp[index][i]) continue;
            stack.addLast(s.substring(index, i + 1));
            dfs(s, i + 1, dp, stack, res);
            stack.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0131().partition("aab"));
    }
}
