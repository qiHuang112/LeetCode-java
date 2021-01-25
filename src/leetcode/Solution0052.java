package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
52. N皇后 II
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。

示例 1：
输入：n = 4
输出：2
解释：如上图所示，4 皇后问题存在两个不同的解法。

示例 2：
输入：n = 1
输出：1

提示：
1 <= n <= 9
皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0052 {
    int res = 0;

    public int totalNQueens(int n) {
        int[][] map = new int[n][n];
        char[][] temp = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = '.';
            }
        }
        dfs(map, 0, temp);
        return res;
    }

    private void dfs(int[][] map, int index, char[][] temp) {
        if (index == map.length) {
            res++;
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[index][i] == 0) {
                temp[index][i] = 'Q';
                spread(map, index, i, 1);
                dfs(map, index + 1, temp);
                temp[index][i] = '.';
                spread(map, index, i, -1);
            }
        }
    }

    private void spread(int[][] map, int x, int y, int value) {
        for (int i = 0; i < map.length; i++) {
            map[x][i] += value;
            map[i][y] += value;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i + j == x + y) map[i][j] += value;
                if (i - j == x - y) map[i][j] += value;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0052().totalNQueens(4));
        System.out.println(new Solution0052().totalNQueens(1));
    }
}
