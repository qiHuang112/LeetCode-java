package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 

示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, candidates, target, 0, 0, new LinkedList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, int index, int sum, LinkedList<Integer> temp) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[index] > target) break;
            temp.addLast(candidates[i]);
            dfs(res, candidates, target, i + 1, sum + candidates[i], temp);
            temp.removeLast();
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0040().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(new Solution0040().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
