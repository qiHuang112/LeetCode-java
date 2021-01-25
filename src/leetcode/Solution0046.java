package leetcode;

import java.util.*;

/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0046 {
    /**
     * 栈实现
     */
    public List<List<Integer>> permute1(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) return res;
        int index = 1;
        res.addLast(List.of(nums[0]));
        while (index < nums.length) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = res.removeFirst();
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> next = new ArrayList<>(list);
                    next.add(j, nums[index]);
                    res.addLast(next);
                }
            }
            index++;
        }
        return res;
    }

    /**
     * 交换元素位置实现
     * (洗牌算法)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i : nums) {
                temp.add(i);
            }
            res.add(temp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(res, nums, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0046().permute(new int[]{}));
        System.out.println(new Solution0046().permute(new int[]{1}));
        System.out.println(new Solution0046().permute(new int[]{1, 2}));
        System.out.println(new Solution0046().permute(new int[]{1, 2, 3}));
        System.out.println(new Solution0046().permute(new int[]{1, 2, 3, 4}));
    }
}
