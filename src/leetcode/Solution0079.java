package leetcode;

/*
79. 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

提示：
board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0079 {
    public boolean exist(char[][] board, String word) {
        int x = board.length, y = board[0].length;
        boolean[][] map = new boolean[x][y];
        char[] chars = word.toCharArray();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == chars[0]) {
                    if (dfs(board, i, j, map, chars, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] map, char[] chars, int index) {
        if (index == chars.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || map[i][j] || board[i][j] != chars[index]) {
            return false;
        }
        map[i][j] = true;
        boolean res = dfs(board, i + 1, j, map, chars, index + 1) || dfs(board, i, j + 1, map, chars, index + 1)
                || dfs(board, i - 1, j, map, chars, index + 1) || dfs(board, i, j - 1, map, chars, index + 1);
        map[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0079().exist(new char[][]{
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray(),
        }, "ABCCED"));
        System.out.println(new Solution0079().exist(new char[][]{
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray(),
        }, "SEE"));
        System.out.println(new Solution0079().exist(new char[][]{
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray(),
        }, "ABCB"));
    }
}
