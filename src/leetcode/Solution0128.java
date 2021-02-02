package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
128. 最长连续序列
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？

示例 1：
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

示例 2：
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9

提示：
0 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int curLen = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }

    public int longestConsecutive1(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);
        }
        int res = 0;
        for (int i : map.keySet()) {
            if (map.get(i)) continue;
            int left = i - 1, right = i + 1;
            while (map.containsKey(left)) map.put(left--, true);
            while (map.containsKey(right)) map.put(right++, true);
            res = Math.max(res, right - left - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new Solution0128().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
