package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
166. 分数到小数
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
如果小数部分为循环小数，则将循环的部分括在括号内。
如果存在多个答案，只需返回 任意一个 。
对于所有给定的输入，保证 答案字符串的长度小于 104 。

示例 1：
输入：numerator = 1, denominator = 2
输出："0.5"

示例 2：
输入：numerator = 2, denominator = 1
输出："2"

示例 3：
输入：numerator = 2, denominator = 3
输出："0.(6)"

示例 4：
输入：numerator = 4, denominator = 333
输出："0.(012)"

示例 5：
输入：numerator = 1, denominator = 5
输出："0.2"

提示：
-2^31 <= numerator, denominator <= 2^31 - 1
denominator != 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        return fractionToDecimal((long) numerator, (long) denominator);
    }

    private String fractionToDecimal(long n, long d) {
        StringBuilder res = new StringBuilder();

        // 符号
        boolean flag = n < 0 && d < 0 || n > 0 && d > 0;
        if (!flag) res.append("-");

        // 小数点前
        n = Math.abs(n);
        d = Math.abs(d);
        res.append(n / d);

        if (n % d == 0) return res.toString();
        res.append('.');
        n %= d;

        // 小数点后
        Map<Long, Integer> map = new HashMap<>();
        map.put(n, res.length());
        while (n != 0) {
            n *= 10;
            res.append(n / d);
            n %= d;
            if (map.containsKey(n)) {
                res.insert(map.get(n), "(").append(")");
                break;
            } else {
                map.put(n, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution0166().fractionToDecimal(1, 2));
        System.out.println(new Solution0166().fractionToDecimal(2, 1));
        System.out.println(new Solution0166().fractionToDecimal(2, 3));
        System.out.println(new Solution0166().fractionToDecimal(-2, 3));
        System.out.println(new Solution0166().fractionToDecimal(4, 333));
        System.out.println(new Solution0166().fractionToDecimal(4, 3333));
        System.out.println(new Solution0166().fractionToDecimal(1, 5));
        System.out.println(new Solution0166().fractionToDecimal(1, 6));
        System.out.println(new Solution0166().fractionToDecimal(1, 7));
        System.out.println(new Solution0166().fractionToDecimal(111, 9));
        System.out.println(new Solution0166().fractionToDecimal(-111, 9));
        System.out.println(new Solution0166().fractionToDecimal(-1, Integer.MIN_VALUE));
    }
}
