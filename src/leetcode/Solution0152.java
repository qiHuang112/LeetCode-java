package leetcode;

/*
152. 乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * 动态规划
 * 设max[i]为以index为i结尾的最大子数组乘积，min[i]为以index为i结尾的最小子数组乘积
 * 则有：
 * max[i] = max[i-1] == 0 ? nums[i] : Math.max(max[i-1]*nums[i], min[i-1]*nums[i]);
 * min[i] = min[i-1] == 0 ? nums[i] : Math.min(max[i-1]*nums[i], min[i-1]*nums[i]);
 */
public class Solution0152 {
    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, max[i]);
        }
        System.out.println(Arrays.toString(max));
        System.out.println(Arrays.toString(min));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0152().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Solution0152().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new Solution0152().maxProduct(new int[]{0, 2, 6, -2, 0, -3, -2, 4}));
        System.out.println(new Solution0152().maxProduct(new int[]{3, -1, 4}));
        System.out.println(new Solution0152().maxProduct(new int[]{-1, -2, -9, -6}));
    }
}
