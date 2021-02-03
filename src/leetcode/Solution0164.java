package leetcode;

import java.util.Arrays;

/*
164. 最大间距
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
如果数组元素个数小于 2，则返回 0。

示例 1:
输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。

示例 2:
输入: [10]
输出: 0
解释: 数组元素个数小于 2，因此返回 0。

说明:
你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-gap
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 不是，费半天功夫写桶排序，然后发现直接Arrays.sort()比这还快
 * 这测试集设置的太不合理了8
 */
public class Solution0164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int d = Math.max(1, (max - min) / (nums.length - 1));
        int bucketSize = (max - min) / d + 1;
        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; i++) {
            Arrays.fill(bucket[i], -1);
        }
        for (int num : nums) {
            int index = (num - min) / d;
            if (bucket[index][0] == -1) {
                bucket[index][0] = bucket[index][1] = num;
            } else {
                bucket[index][0] = Math.min(bucket[index][0], num);
                bucket[index][1] = Math.max(bucket[index][1], num);
            }
        }
        int res = 0;
        int pre = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (pre != -1) {
                res = Math.max(res, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0164().maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(new Solution0164().maximumGap(new int[]{10}));
    }
}
