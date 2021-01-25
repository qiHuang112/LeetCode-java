package basic;

import java.util.Arrays;

/**
 * 快速排序
 * 思路：填坑法
 * 将数组的某一个数填到某个位置，使得左边的数都比它本身小，右边的数都比它本身大
 * 此时数组被这个数分为两个部分，递归。
 */
public class QuickSort {
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int target = nums[start];
        int l = start, r = end;
        while (l < r) {
            while (l < r && nums[r] >= target) r--;
            if (l < r) nums[l++] = nums[r];
            while (l < r && nums[l] <= target) l++;
            if (l < r) nums[r--] = nums[l];
        }
        nums[l] = target;
        sort(nums, start, l - 1);
        sort(nums, l + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{35, 88, 45, 37, 91, 26, 13, 66, 50};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
