package leetcode;

/*
190. 颠倒二进制位
颠倒给定的 32 位无符号整数的二进制位。

示例 1：
输入: 00000010100101000001111010011100
输出: 00111001011110000010100101000000
解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。

示例 2：
输入：11111111111111111111111111111101
输出：10111111111111111111111111111111
解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 
进阶:
如果多次调用这个函数，你将如何优化你的算法？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-bits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0190 {
    public int reverseBits(int n) {
        int res = 0;
        int count = 32;
        while (count-- > 0) {
            res <<= 1;
            res |= n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(new Solution0190().reverseBits(0b00000010100101000001111010011100)));
        System.out.println(Integer.toBinaryString(new Solution0190().reverseBits(0b11111111111111111111111111111101)));
    }
}
