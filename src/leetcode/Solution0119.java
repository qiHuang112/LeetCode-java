package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
119. 杨辉三角 II
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 3
输出: [1,3,3,1]

进阶：
你可以优化你的算法到 O(k) 空间复杂度吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (rowIndex-- > 0) {
            res = getRes(res);
        }
        return res;
    }

    private List<Integer> getRes(List<Integer> res) {
        List<Integer> next = new ArrayList<>();
        for (int i = -1; i < res.size(); i++) {
            if (i == -1 || i == res.size() - 1) {
                next.add(1);
            } else {
                next.add(res.get(i) + res.get(i + 1));
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0119().getRow(3));
        System.out.println(new Solution0119().getRow(0));
    }
}