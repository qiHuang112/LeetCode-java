package leetcode;

/*
32. 最长有效括号
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

示例 1：
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"

示例 2：
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"

示例 3：
输入：s = ""
输出：0
 
提示：
0 <= s.length <= 3 * 10^4
s[i] 为 '(' 或 ')'

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0032 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    dp[i] = 0;
                    break;
                case ')':
                    if (i > 0) {
                        if (s.charAt(i - 1) == '(') {
                            dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
                        } else {
                            if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0);
                            } else {
                                dp[i] = 0;
                            }
                        }
                    } else {
                        dp[i] = 0;
                    }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0032().longestValidParentheses("(()"));
        System.out.println(new Solution0032().longestValidParentheses(")()())"));
        System.out.println(new Solution0032().longestValidParentheses(""));
        System.out.println(new Solution0032().longestValidParentheses("()(()"));
        System.out.println(new Solution0032().longestValidParentheses("()(())"));
    }
}
