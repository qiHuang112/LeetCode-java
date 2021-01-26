package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
59. 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0059 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0, j = 0, d = 0;
        int count = 1;
        int[][] arr = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}};
        boolean[][] map = new boolean[n][n];
        while (count <= n * n) {
            matrix[i][j] = count++;
            map[i][j] = true;
            int x = i + arr[d][0], y = j + arr[d][1];
            if (x < 0 || x >= n || y < 0 || y >= n || map[x][y]) {
                d = (d + 1) % 4;
            }
            i += arr[d][0];
            j += arr[d][1];
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution0059().generateMatrix(3)));
    }
}
