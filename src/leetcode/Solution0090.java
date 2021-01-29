package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
90. 子集 II
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index, LinkedList<Integer> temp) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 第一个不要，后面的才能不要
        if (temp.isEmpty() || temp.peekLast() != nums[index]) {
            dfs(res, nums, index + 1, temp);
        }
        temp.addLast(nums[index]);
        dfs(res, nums, index + 1, temp);
        temp.removeLast();
    }

    public static void main(String[] args) {
        System.out.println(new Solution0090().subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(new Solution0090().subsetsWithDup(new int[]{1, 2, 2, 2}));
    }
}
