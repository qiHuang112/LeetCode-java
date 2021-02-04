package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
179. 最大数
给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

示例 1：
输入：nums = [10,2]
输出："210"

示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"

示例 3：
输入：nums = [1]
输出："1"

示例 4：
输入：nums = [10]
输出："10"

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0179 {
    public String largestNumber(int[] nums) {
        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }
        Arrays.sort(integers, (o1, o2) -> ("" + o2 + o1).compareTo("" + o1 + o2));
        StringBuilder res = new StringBuilder();
        for (Integer integer : integers) {
            res.append(integer);
        }
        int index = 0;
        while (res.charAt(index) == '0' && index < res.length() - 1) {
            index++;
        }
        return res.substring(index);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0179().largestNumber(new int[]{10, 2}));
        System.out.println(new Solution0179().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new Solution0179().largestNumber(new int[]{1}));
        System.out.println(new Solution0179().largestNumber(new int[]{10}));
        System.out.println(new Solution0179().largestNumber(new int[]{0, 0}));

    }
}
