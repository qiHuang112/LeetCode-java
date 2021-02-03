package leetcode;

/*
151. 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。

说明：
无空格字符构成一个 单词 。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

示例 1：
输入："the sky is blue"
输出："blue is sky the"

示例 2：
输入："  hello world!  "
输出："world! hello"
解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入："a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

示例 4：
输入：s = "  Bob    Loves  Alice   "
输出："Alice Loves Bob"

示例 5：
输入：s = "Alice does not even like bob"
输出："bob like even not does Alice"
 
提示：
1 <= s.length <= 10^4
s 包含英文大小写字母、数字和空格 ' '
s 中 至少存在一个 单词

进阶：
请尝试使用 O(1) 额外空间复杂度的原地解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0151 {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') continue;
            int index = res.length();
            while (i >= 0 && chars[i] != ' ') {
                res.insert(index, chars[i]);
                i--;
            }
            res.append(' ');
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0151().reverseWords("the sky is blue"));
        System.out.println(new Solution0151().reverseWords("  hello world!  "));
        System.out.println(new Solution0151().reverseWords("a good   example"));
        System.out.println(new Solution0151().reverseWords("  Bob    Loves  Alice   "));
        System.out.println(new Solution0151().reverseWords("Alice does not even like bob"));
    }
}
