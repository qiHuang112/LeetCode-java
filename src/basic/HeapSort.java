package basic;

import java.util.Arrays;

/**
 * 堆排序
 * 思路：
 * 先构建大顶堆
 * 将最后一个数与最前一个数交换，然后调整大顶堆（小数下沉）
 * n次操作后，完成排序
 */
public class HeapSort {
    public static void sort(int[] nums) {
        // 构建大顶堆
        for (int i = nums.length / 2; i >= 0; i--) {
            siftDown(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            siftDown(nums, 0, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void siftDown(int[] nums, int i, int j) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{35, 88, 45, 37, 91, 26, 13, 66, 50};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
