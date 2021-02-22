package leetcode;

/*
209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

示例 1：
输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。

示例 2：
输入：target = 4, nums = [1,4,4]
输出：1

示例 3：
输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0

提示：
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
 
进阶：
如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int cur = nums[0], l = 0, r = 0, min = Integer.MAX_VALUE;
        while (true) {
            if (cur < target) {
                if (r == nums.length - 1) break;
                cur += nums[++r];
            } else {
                min = Math.min(min, r - l + 1);
                cur -= nums[l++];
            }
        }
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Solution0209().minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(new Solution0209().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
