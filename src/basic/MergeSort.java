package basic;

import java.util.Arrays;

/**
 * 归并排序
 * 思路：广度优先
 * 1.将数组分成左右排序好的两部分，
 * 2.每次取两个数组的较小数放入结果数组
 */
public class MergeSort {

    public static void sort(int[] nums) {
        if (nums.length <= 1) return;
        int[] a = Arrays.copyOfRange(nums, 0, nums.length / 2);
        int[] b = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
        sort(a);
        sort(b);
        int i = 0, j = 0;
        while (i < a.length || j < b.length) {
            if (i == a.length) {
                nums[i + j] = b[j++];
            } else if (j == b.length) {
                nums[i + j] = a[i++];
            } else if (a[i] < b[j]) {
                nums[i + j] = a[i++];
            } else {
                nums[i + j] = b[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{35, 88, 45, 37, 91, 26, 13, 66, 50};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
