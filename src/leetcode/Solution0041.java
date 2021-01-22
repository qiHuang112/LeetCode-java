package leetcode;

import java.util.Arrays;

/*
41. 缺失的第一个正数
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？

示例 1：
输入：nums = [1,2,0]
输出：3

示例 2：
输入：nums = [3,4,-1,1]
输出：2

示例 3：
输入：nums = [7,8,9,11,12]
输出：1

提示：
0 <= nums.length <= 300
-2^31 <= nums[i] <= 2^31 - 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-missing-positive
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0041 {
    public int firstMissingPositive(int[] nums) {
        // 第一趟遍历先把所有不在区间的数赋值为 nums.length+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = nums.length + 1;
            }
        }
        // 第二趟遍历将 在区间的数对应的索引值对应的数变成负数
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 第三趟遍历，找出第一个非负数索引
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0041().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new Solution0041().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new Solution0041().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
