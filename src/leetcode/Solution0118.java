package leetcode;

import java.util.*;

/*
118. 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0118 {
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) return res;
        res.addLast(Collections.singletonList(1));
        while (numRows-- > 1) {
            List<Integer> last = res.getLast();
            List<Integer> cur = new ArrayList<>();
            for (int i = -1; i < last.size(); i++) {
                if (i == -1 || i == last.size() - 1) {
                    cur.add(1);
                } else {
                    cur.add(last.get(i) + last.get(i + 1));
                }
            }
            res.addLast(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0118().generate(5));
    }
}
