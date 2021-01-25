package leetcode;

/*
50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:
输入: 2.00000, 10
输出: 1024.00000

示例 2:
输入: 2.10000, 3
输出: 9.26100

示例 3:
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25

说明:
-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0050 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == Integer.MIN_VALUE) return 1 / myPow(x, Integer.MAX_VALUE) / x;
        if (n < 0) return 1 / myPow(x, -n);
        double res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            n /= 2;
            x *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0050().myPow(2.00000, 10));
        System.out.println(new Solution0050().myPow(2.10000, 3));
        System.out.println(new Solution0050().myPow(2.00000, -2));
    }
}
