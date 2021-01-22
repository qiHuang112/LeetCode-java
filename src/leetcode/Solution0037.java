package leetcode;

/*
37. 解数独
编写一个程序，通过填充空格来解决数独问题。
一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。

提示：
给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sudoku-solver
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0037 {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    private boolean solve(char[][] board, int index) {
        if (index == 81) return true;
        int x = index / 9, y = index % 9;
        if (board[x][y] != '.') return solve(board, index + 1);
        boolean[] map = new boolean[9];
        // 行,列
        for (int i = 0; i < 9; i++) {
            if (board[x][i] != '.') map[board[x][i] - '1'] = true;
            if (board[i][y] != '.') map[board[i][y] - '1'] = true;
        }
        // 九宫
        int offsetX = x / 3 * 3, offsetY = y / 3 * 3;
        for (int i = offsetX; i < offsetX + 3; i++) {
            for (int j = offsetY; j < offsetY + 3; j++) {
                if (board[i][j] != '.') map[board[i][j] - '1'] = true;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!map[i]) {
                board[x][y] = (char) (i + '1');
                if (solve(board, index + 1)) return true;
                board[x][y] = '.';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray()
        };
        new Solution0037().solveSudoku(board1);
        for (char[] chars : board1) {
            System.out.println(chars);
        }
        System.out.println();

        char[][] board2 = new char[][]{
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray()
        };
        new Solution0037().solveSudoku(board2);
        for (char[] chars : board2) {
            System.out.println(chars);
        }
    }
}
