package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

示例 2：
输入：n = 1
输出：["()"]

提示：
1 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0022 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, new char[2 * n]);
        return res;
    }

    private void dfs(int i, int j, char[] chars) {
        if (i + j == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (i > j) {
            chars[i + j] = ')';
            dfs(i, j + 1, chars);
        }
        if (i < chars.length / 2) {
            chars[i + j] = '(';
            dfs(i + 1, j, chars);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0022().generateParenthesis(3));
        System.out.println(new Solution0022().generateParenthesis(1));
    }
}
