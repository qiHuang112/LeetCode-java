package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0017 {
    List<String> res = new ArrayList<>();
    String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        dfs(digits, 0, new char[digits.length()]);
        return res;
    }

    private void dfs(String digits, int index, char[] chars) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        for (char c : map[digits.charAt(index) - '2'].toCharArray()) {
            chars[index] = c;
            dfs(digits, index + 1, chars);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0017().letterCombinations("23"));
        System.out.println(new Solution0017().letterCombinations("56"));
        System.out.println(new Solution0017().letterCombinations(""));
    }
}
