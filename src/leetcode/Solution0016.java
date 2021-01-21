package leetcode;

import java.util.Arrays;

/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

提示：
3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0016 {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 2; a++) {
            if (a > 0 && nums[a - 1] == nums[a]) continue;
            int b = a + 1, c = nums.length - 1;
            while (b < c) {
                int total = nums[a] + nums[b] + nums[c];
                if (total == target) {
                    return target;
                }
                if (Math.abs(res - target) > Math.abs(total - target)) {
                    res = total;
                }
                if (total > target) {
                    c--;
                } else {
                    b++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0016().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
