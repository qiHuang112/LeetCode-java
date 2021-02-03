package leetcode;

/*
162. 寻找峰值
峰值元素是指其值大于左右相邻值的元素。
给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
你可以假设 nums[-1] = nums[n] = -∞ 。

示例 1：
输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。

示例 2：
输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5
解释：你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。

提示：
1 <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1
对于所有有效的 i 都有 nums[i] != nums[i + 1]
 
进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-peak-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0162 {
    public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int l, int r) {
        if (l == r) return l;
        int m = (l + r) >>> 1;
        if (nums[m] > nums[m + 1]) {
            return find(nums, l, m);
        }
        return find(nums, m + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0162().findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution0162().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
