package leetcode;

/*
36. 有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

示例 1:
输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true

示例 2:
输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。

说明:
一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0036 {
    public boolean isValidSudoku(char[][] board) {
        // 行
        for (int i = 0; i < 9; i++) {
            boolean[] map = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int index = board[i][j] - '0';
                if (map[index]) return false;
                map[index] = true;
            }
        }
        // 列
        for (int i = 0; i < 9; i++) {
            boolean[] map = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                int index = board[j][i] - '0';
                if (map[index]) return false;
                map[index] = true;
            }
        }
        // 九宫
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] map = new boolean[10];
                for (int k = 3 * i; k < 3 * i + 3; k++) {
                    for (int l = 3 * j; l < 3 * j + 3; l++) {
                        if (board[k][l] == '.') continue;
                        int index = board[k][l] - '0';
                        if (map[index]) return false;
                        map[index] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0036().isValidSudoku(new char[][]{
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray(),
        }));
        System.out.println(new Solution0036().isValidSudoku(new char[][]{
                "83..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray(),
        }));
        System.out.println(new Solution0036().isValidSudoku(new char[][]{
                "....5..1.".toCharArray(),
                ".4.3.....".toCharArray(),
                ".....3..1".toCharArray(),
                "8......2.".toCharArray(),
                "..2.7....".toCharArray(),
                ".15......".toCharArray(),
                ".....2...".toCharArray(),
                ".2.9.....".toCharArray(),
                "..4......".toCharArray(),
        }));
    }
}
