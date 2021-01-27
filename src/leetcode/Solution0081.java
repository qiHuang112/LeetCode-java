package leetcode;

import java.util.Stack;

/*
81. 搜索旋转排序数组 II
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

示例 1:
输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true

示例 2:
输入: nums = [2,5,6,0,0,1,2], target = 3
输出: false

进阶:
这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0081 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[left] < nums[mid]) { // 0~mid 有序 递增
                if (nums[left] <= target && target < nums[mid]) { // target在0~mid
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // mid~nums.length-1 有序递增
                if (nums[mid] < target && target <= nums[right]) { // target在mid~nums.length-1
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0081().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(new Solution0081().search(new int[]{1, 0, 1, 1, 1}, 0));
        System.out.println(new Solution0081().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }
}
