package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

示例 2：
输入：height = [4,2,0,3,2,5]
输出：9
 
提示：
n == height.length
0 <= n <= 3 * 10^4
0 <= height[i] <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * todo 使用双指针实现
 */
public class Solution0042 {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int cur = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = Math.max(cur, height[i]);
            cur = leftMax[i];
        }
        cur = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = Math.max(cur, height[i]);
            cur = rightMax[i];
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public int trap1(int[] height) {
        if (height.length <= 2) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> height[o2] - height[o1]);
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += height[i];
            queue.add(i);
        }
        int res = height[0];
        queue.remove(0);
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] < height[i - 1]) {
                height[i] = Math.min(height[i - 1], height[queue.peek()]);
            }
            res += height[i];
            queue.remove(i);
        }
        return res + height[height.length - 1] - sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0042().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Solution0042().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
