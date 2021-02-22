package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
212. 单词搜索 II
给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例 1：
输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
输出：["eat","oath"]

示例 2：
输入：board = [["a","b"],["c","d"]], words = ["abcb"]
输出：[]

提示：
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] 是一个小写英文字母
1 <= words.length <= 3 * 10^4
1 <= words[i].length <= 10
words[i] 由小写英文字母组成
words 中的所有字符串互不相同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0212 {
    int m, n;
    private boolean[][] map;

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        map = new boolean[m][n];
        List<String> res = new ArrayList<>();
        label:
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, word, 0)) {
                        res.add(word);
                        continue label;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (i < 0 || i >= m || j < 0 || j >= n || map[i][j] || word.charAt(index) != board[i][j]) return false;
        if (index == word.length() - 1) return true;
        map[i][j] = true;
        boolean res = dfs(board, i + 1, j, word, index + 1) || dfs(board, i, j + 1, word, index + 1) || dfs(board, i - 1, j, word, index + 1) || dfs(board, i, j - 1, word, index + 1);
        map[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0212().findWords(new char[][]{
                "oaan".toCharArray(),
                "etae".toCharArray(),
                "ihkr".toCharArray(),
                "iflv".toCharArray(),
        }, new String[]{"oath", "pea", "eat", "rain"}));

        System.out.println(new Solution0212().findWords(new char[][]{
                "ab".toCharArray(),
                "cd".toCharArray(),
        }, new String[]{"abcb"}));

        System.out.println(new Solution0212().findWords(new char[][]{
                "oabn".toCharArray(),
                "otae".toCharArray(),
                "ahkr".toCharArray(),
                "afiv".toCharArray(),
        }, new String[]{"oa", "oaa"}));
    }
}
