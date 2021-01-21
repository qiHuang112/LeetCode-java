package leetcode;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

示例 2：
输入：nums = []
输出：[]

示例 3：
输入：nums = [0]
输出：[]

提示：
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 2; a++) {
            if (a > 0 && nums[a - 1] == nums[a]) continue;
            int b = a + 1, c = nums.length - 1;
            while (b < c) {
                int total = nums[a] + nums[b] + nums[c];
                if (total == 0) {
                    res.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    while (b < c && nums[b] == nums[b + 1]) b++;
                    while (b < c && nums[c] == nums[c - 1]) c--;
                }
                if (total > 0) {
                    c--;
                } else {
                    b++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0015().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new Solution0015().threeSum(new int[]{}));
        System.out.println(new Solution0015().threeSum(new int[]{0}));
        System.out.println(new Solution0015().threeSum(new int[]{0, 0, 0, 0, 0}));
        System.out.println(new Solution0015().threeSum(new int[]{0, 0, 0, 0}));
    }
}
/*
-4,-1,-1,0,1,2
 */
