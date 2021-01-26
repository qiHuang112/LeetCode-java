package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

/*
56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:
输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2:
输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。

提示：
intervals[i][0] <= intervals[i][1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * todo 算法优化
 */
public class Solution0056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Stack<int[]> res = new Stack<>();
        for (int[] interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
            } else if (res.peek()[1] >= interval[0]) {
                int[] a = res.pop();
                int b = Math.max(interval[1], a[1]);
                res.add(new int[]{a[0], b});
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution0056().merge(new int[][]{
                new int[]{2, 3},
                new int[]{2, 2},
                new int[]{3, 3},
                new int[]{1, 3},
                new int[]{5, 7},
                new int[]{2, 2},
                new int[]{4, 6},
        })));
        System.out.println(Arrays.deepToString(new Solution0056().merge(new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18},
        })));
        System.out.println(Arrays.deepToString(new Solution0056().merge(new int[][]{
                new int[]{1, 4},
                new int[]{2, 3},
        })));
    }

}
