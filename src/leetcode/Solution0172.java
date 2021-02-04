package leetcode;

/*
172. 阶乘后的零
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例 2:
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.
说明: 你算法的时间复杂度应为 O(log n) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0172().trailingZeroes(3));
        System.out.println(new Solution0172().trailingZeroes(5));
        System.out.println(new Solution0172().trailingZeroes(10));
    }
}
