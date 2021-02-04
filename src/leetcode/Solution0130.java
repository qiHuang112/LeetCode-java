package leetcode;

/*
130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:
X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X

解释:
被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surrounded-regions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0130 {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        boolean[][] map = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, map, i, j, 'O', '#');
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, map, i, j, 'O', 'X');
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] map, int i, int j, char from, char to) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] || board[i][j] != from) {
            return;
        }
        map[i][j] = true;
        board[i][j] = to;
        dfs(board, map, i + 1, j, from, to);
        dfs(board, map, i, j + 1, from, to);
        dfs(board, map, i - 1, j, from, to);
        dfs(board, map, i, j - 1, from, to);
        map[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                "XXXX".toCharArray(),
                "XOOX".toCharArray(),
                "XXOX".toCharArray(),
                "XOXX".toCharArray(),
        };
        new Solution0130().solve(board);
        for (char[] chars : board) {
            System.out.println(new String(chars));
        }
    }
}