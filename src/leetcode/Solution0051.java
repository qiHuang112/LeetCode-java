package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
51. N 皇后
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例 1：
输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。

示例 2：
输入：n = 1
输出：[["Q"]]

提示：
1 <= n <= 9
皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * todo 优化算法
 */
public class Solution0051 {
    public List<List<String>> solveNQueens(int n) {
        int[][] map = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        char[][] temp = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = '.';
            }
        }
        dfs(res, map, 0, temp);
        return res;
    }

    private void dfs(List<List<String>> res, int[][] map, int index, char[][] temp) {
        if (index == map.length) {
            List<String> l = new ArrayList<>();
            for (char[] chars : temp) {
                l.add(new String(chars));
            }
            res.add(l);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[index][i] == 0) {
                temp[index][i] = 'Q';
                spread(map, index, i, 1);
                dfs(res, map, index + 1, temp);
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
        List<List<String>> res = new Solution0051().solveNQueens(5);
        for (List<String> strings : res) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println();
        }
    }
}
