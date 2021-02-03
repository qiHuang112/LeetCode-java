package leetcode;

/*
153. 寻找旋转排序数组中的最小值
假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
请找出其中最小的元素。

示例 1：
输入：nums = [3,4,5,1,2]
输出：1

示例 2：
输入：nums = [4,5,6,7,0,1,2]
输出：0

示例 3：
输入：nums = [1]
输出：1

提示：
1 <= nums.length <= 5000
-5000 <= nums[i] <= 5000
nums 中的所有整数都是 唯一 的
nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0153 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int l, int r) {
        if (l == r || nums[l] < nums[r]) return nums[l];
        int m = (l + r) >>> 1;
        if (nums[m] >= nums[0]) {
            return findMin(nums, m + 1, r);
        }
        return findMin(nums, l, m);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0153().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution0153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new Solution0153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new Solution0153().findMin(new int[]{4, 5, 6, 7, -3, -2, -1, 0, 1, 2}));
        System.out.println(new Solution0153().findMin(new int[]{2, 1}));
        System.out.println(new Solution0153().findMin(new int[]{0, 1}));
    }
}
