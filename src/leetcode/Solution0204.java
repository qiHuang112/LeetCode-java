package leetcode;

import java.util.Arrays;

/*
204. 计数质数
统计所有小于非负整数 n 的质数的数量。
示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

示例 2：
输入：n = 0
输出：0

示例 3：
输入：n = 1
输出：0

提示：
0 <= n <= 5 * 10^6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-primes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0204 {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] dp = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!dp[i]) {
                res++;
                for (int j = i; j < n; j += i) {
                    dp[j] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0204().countPrimes(10));
        System.out.println(new Solution0204().countPrimes(0));
        System.out.println(new Solution0204().countPrimes(1));
    }
}
/*
0 1 2 3 4 5 6 7 8 9
- - - - - - - - - -
0 0 1 - 0 - 0 - 0 -
0 0 1 1 0 - 0 - 0 0
0 0 1 1 0 1 0 1 0 0
 */