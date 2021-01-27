package leetcode;

import java.util.Arrays;

/*
80. 删除排序数组中的重复项 II
给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1：
输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。

示例 2：
输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 你不需要考虑数组中超出新长度后面的元素。

提示：
0 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
nums 按递增顺序排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0080 {
    public int removeDuplicates(int[] nums) {
        int count = 1, index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count < 2) {
                    nums[index++] = nums[i];
                    count++;
                }
            } else {
                nums[index++] = nums[i];
                count = 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int len = new Solution0080().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, len)));

        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        len = new Solution0080().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, len)));
    }
}
