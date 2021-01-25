package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
47. 全排列 II
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

提示：
1 <= nums.length <= 8
-10 <= nums[i] <= 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] map = new int[21];
        for (int i : nums) {
            map[10 + i]++;
        }
        dfs(res, map, 0, new int[nums.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] map, int index, int[] temp) {
        if (index == temp.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : temp) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < 21; i++) {
            if (map[i] > 0) {
                temp[index] = i - 10;
                map[i]--;
                dfs(res, map, index + 1, temp);
                map[i]++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0047().permuteUnique(new int[]{0, 1, 0, 0, 9}));
        System.out.println(new Solution0047().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new Solution0047().permuteUnique(new int[]{1, 2, 3}));
    }
}
