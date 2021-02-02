package leetcode;

import java.util.Arrays;

/*
132. 分割回文串 II
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回符合要求的最少分割次数。

示例:
输入: "aab"
输出: 1
解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0132 {
    public int minCut(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n - 1);
        for (int i = 0; i < n; i++) {
            spread(chars, i, i, dp);
            spread(chars, i, i + 1, dp);
        }
        return dp[n - 1];
    }

    private void spread(char[] chars, int i, int j, int[] dp) {
        while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
            dp[j] = Math.min(dp[j], i == 0 ? 0 : dp[i - 1] + 1);
            i--;
            j++;
        }
    }

    public int minCut1(String s) {
        if (s.length() <= 1) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = i;
        }
        for (int i = 1; i < n; i++) {
            if (dp[0][i]) {
                res[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i]) {
                    res[i] = Math.min(res[i], res[j] + 1);
                }
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution0132().minCut("aab"));
    }
}
