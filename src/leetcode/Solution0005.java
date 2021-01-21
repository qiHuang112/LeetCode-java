package leetcode;

/*
5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。

示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"

示例 3：
输入：s = "a"
输出："a"

示例 4：
输入：s = "ac"
输出："a"
 
提示：
1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution0005 {
    int start = 0, end = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            spread(s, i, i);
            spread(s, i + 1, i);
        }
        return s.substring(start, end + 1);
    }

    private void spread(String s, int left, int right) {
        while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
            left--;
            right++;
        }
        if (right - left > end - start) {
            start = left;
            end = right;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0005().longestPalindrome("babad"));
        System.out.println(new Solution0005().longestPalindrome("cbbd"));
        System.out.println(new Solution0005().longestPalindrome("a"));
        System.out.println(new Solution0005().longestPalindrome("ac"));
    }
}
