package leetcode;

import java.util.Arrays;

/*
66. 加一
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1：
输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。

示例 2：
输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。

示例 3：
输入：digits = [0]
输出：[1]
 
提示：
1 <= digits.length <= 100
0 <= digits[i] <= 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0066 {
    public int[] plusOne(int[] digits) {
        int carry = 1, temp;
        for (int i = digits.length - 1; i >= 0; i--) {
            temp = digits[i] + carry;
            digits[i] = temp % 10;
            carry = temp / 10;
            if (carry == 0) {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        System.arraycopy(digits, 0, res, 1, digits.length);
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution0066().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new Solution0066().plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(new Solution0066().plusOne(new int[]{0})));
        System.out.println(Arrays.toString(new Solution0066().plusOne(new int[]{9})));
        System.out.println(Arrays.toString(new Solution0066().plusOne(new int[]{9, 9})));
    }
}
