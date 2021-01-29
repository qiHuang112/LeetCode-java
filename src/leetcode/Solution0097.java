package leetcode;

/*
97. 交错字符串
给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
提示：a + b 意味着字符串 a 和 b 连接。

示例 1：
输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出：true

示例 2：
输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出：false

示例 3：
输入：s1 = "", s2 = "", s3 = ""
输出：true

提示：
0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1、s2、和 s3 都由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/interleaving-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        int l1 = chars1.length, l2 = chars2.length, l3 = chars3.length;
        if (l1 + l2 != l3) return false;
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] && chars1[i - 1] == chars3[i - 1];
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = dp[0][i - 1] && chars2[i - 1] == chars3[i - 1];
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = (dp[i - 1][j] && chars1[i - 1] == chars3[i + j - 1]) || (dp[i][j - 1] && chars2[j - 1] == chars3[i + j - 1]);
            }
        }
        return dp[l1][l2];
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if ((s1 + s2).equals(s3) || (s2 + s1).equals(s3)) return true;
        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }

    private boolean dfs(char[] chars1, char[] chars2, char[] chars3, int i1, int i2, int i3) {
        if (i3 == chars3.length) return true;
        return (i1 < chars1.length && chars1[i1] == chars3[i3] && dfs(chars1, chars2, chars3, i1 + 1, i2, i3 + 1)) ||
                (i2 < chars2.length && chars2[i2] == chars3[i3] && dfs(chars1, chars2, chars3, i1, i2 + 1, i3 + 1));
    }

    public static void main(String[] args) {
        System.out.println(new Solution0097().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Solution0097().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(new Solution0097().isInterleave("", "", ""));
    }
}
