package leetcode;

/*
137. 只出现一次的数字 II

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
输入: [2,2,3,2]
输出: 3

示例 2:
输入: [0,1,0,1,0,1,99]
输出: 99
 */

/**
 * a b n    ab  b=~a&(b^n) a=~b&(a^n)
 * 0 0 1 -> 01
 * 0 1 1 -> 10
 * 1 0 1 -> 00
 * 0 0 0 -> 00
 * 0 1 0 -> 01
 * 1 0 0 -> 10
 */
public class Solution0137 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0137().singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(new Solution0137().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
