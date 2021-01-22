package leetcode;

import java.util.Arrays;

/*
34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：
你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]

提示：
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums 是一个非递减数组
-10^9 <= target <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0034 {
    public int[] searchRange(int[] nums, int target) {
        int i = search(nums, target);
        return new int[]{getLeft(i, nums), getRight(i, nums)};
    }

    private int getLeft(int i, int[] nums) {
        if (i == -1) return -1;
        int left = 0, right = i;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] != nums[i] && nums[mid + 1] == nums[i]) {
                return mid + 1;
            }
            if (nums[mid] != nums[i]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int getRight(int i, int[] nums) {
        if (i == -1) return -1;
        int left = i, right = nums.length - 1;
        if (nums[right] == nums[i]) return right;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == nums[i] && nums[mid + 1] != nums[i]) {
                return mid;
            }
            if (nums[mid] != nums[i]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution0034().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution0034().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new Solution0034().searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution0034().searchRange(new int[]{8, 8, 8, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution0034().searchRange(new int[]{8, 8, 8, 8, 8}, 8)));
        System.out.println(Arrays.toString(new Solution0034().searchRange(new int[]{}, 0)));
    }
}
