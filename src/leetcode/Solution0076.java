package leetcode;

/*
76. 最小覆盖子串
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

示例 1：
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"

示例 2：
输入：s = "a", t = "a"
输出："a"

提示：
1 <= s.length, t.length <= 10^5
s 和 t 由英文字母组成

进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0076 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]--;
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        while (right < chars.length) {
            map[chars[right++]]++;
            if (right - left >= t.length() && isAvailable(map)) break;
        }
        if (!isAvailable(map)) return "";
        while (map[chars[left]] > 0) map[chars[left++]]--;
        int a = left, b = right;
        while (right < chars.length) {
            while (right < chars.length && chars[right] != chars[left]) map[chars[right++]]++;
            if (right == chars.length) break;
            map[chars[right++]]++;
            map[chars[left++]]--;
            while (map[chars[left]] > 0) map[chars[left++]]--;
            if (right - left < b - a) {
                a = left;
                b = right;
            }
        }
        return new String(chars, a, b - a);
    }

    private boolean isAvailable(int[] map) {
        for (int i = 'a'; i <= 'z'; i++) if (map[i] < 0) return false;
        for (int i = 'A'; i <= 'Z'; i++) if (map[i] < 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0076().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution0076().minWindow("a", "a"));
        System.out.println(new Solution0076().minWindow("addfafdafax", "dfx"));
        System.out.println(new Solution0076().minWindow("aaflslflsldkalskaaa", "aaa"));
        System.out.println(new Solution0076().minWindow("adobecodebancbbcaa", "abc"));
    }
}
/*
adobecodebancbbcaa
adobec
     codeba
         banc
          ancb
              bca
 */