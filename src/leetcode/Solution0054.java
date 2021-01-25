package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
54. 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]

示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int i = 0, j = 0, d = 0;
        int m = matrix.length, n = matrix[0].length;
        int count = m * n;
        int[][] arr = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}};
        boolean[][] map = new boolean[m][n];
        while (count-- > 0) {
            res.add(matrix[i][j]);
            map[i][j] = true;
            int x = i + arr[d][0], y = j + arr[d][1];
            if (x < 0 || x >= m || y < 0 || y >= n || map[x][y]) {
                d = (d + 1) % 4;
            }
            i += arr[d][0];
            j += arr[d][1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0054().spiralOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        }));
        System.out.println(new Solution0054().spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
        }));
    }
}
