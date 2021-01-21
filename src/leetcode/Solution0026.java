package leetcode;

import java.util.Arrays;

/*
26. 删除排序数组中的重复项
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1:
给定数组 nums = [1,1,2],
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
你不需要考虑数组中超出新长度后面的元素。

示例 2:
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。
 
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0026 {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            nums[index++] = nums[i];
        }
        return index;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 1, 2};
        int len1 = new Solution0026().removeDuplicates(num1);
        System.out.println(Arrays.toString(Arrays.copyOfRange(num1, 0, len1)));

        int[] num2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = new Solution0026().removeDuplicates(num2);
        System.out.println(Arrays.toString(Arrays.copyOfRange(num2, 0, len2)));
    }
}
