package leetcode;

/*
215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0215 {
    /**
     * 大顶堆
     */
    public int findKthLargest(int[] nums, int k) {
        // 构建大顶堆
        for (int i = nums.length / 2; i >= 0; i--) {
            sift(nums, i, nums.length);
        }

        for (int i = 0; i < k; i++) {
            swap(nums, 0, nums.length - i - 1);
            sift(nums, 0, nums.length - i - 1);
        }
        return nums[nums.length - k];
    }

    private void sift(int[] nums, int i, int j) {
        int target = nums[i];
        int parent = i, child;
        while ((child = (parent << 1) + 1) < j) {
            if (child + 1 < j && nums[child + 1] > nums[child]) child++;
            if (target >= nums[child]) break;
            nums[parent] = nums[child];
            parent = child;
        }
        nums[parent] = target;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new Solution0215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(new Solution0215().findKthLargest(new int[]{2, 1}, 1));
    }
}
