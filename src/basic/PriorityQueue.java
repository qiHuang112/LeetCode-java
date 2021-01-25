package basic;

import java.util.Arrays;

/**
 * 优先队列
 * 功能：
 * 1.offer - 添加，如果达到容量上限且无法自动扩容，返回false
 * 2.poll - 移除 -- 按顺序
 * 3.peek - 查看栈顶元素
 * 4.grow - 如果达到容量上限，自动扩容
 * 5.isEmpty - 检查是否为空
 * 思路：
 * 构建小顶堆
 * 每次offer，将数据放到末尾，向上调整（小数上浮）
 * 每次poll，将末尾的数放到最前，向下调整（大数下沉）
 */
public class PriorityQueue {
    int size = 0;
    int[] nums;

    public PriorityQueue() {
        nums = new int[16];
    }

    public boolean offer(int n) {
        if (size == nums.length) grow();
        if (size == nums.length) return false;
        // 小数上浮
        siftUp(n, size++);
        return true;
    }

    private void siftUp(int target, int i) {
        int child = i, parent;
        while (child > 0) {
            parent = (child - 1) >> 1;
            if (nums[parent] <= target) break;
            nums[child] = nums[parent];
            child = parent;
        }
        nums[child] = target;
    }

    public int poll() {
        if (isEmpty()) throw new IndexOutOfBoundsException("队列为空");
        int res = nums[0];
        size--;
        // 大数下沉
        siftDown(nums[size], size);
        return res;
    }

    private void siftDown(int target, int i) {
        int parent = 0, child;
        while ((child = (parent << 1) + 1) < i) {
            if (child + 1 < i && nums[child + 1] < nums[child]) child++;
            if (target <= nums[child]) break;
            nums[parent] = nums[child];
            parent = child;
        }
        nums[parent] = target;
    }

    public int peek() {
        if (isEmpty()) throw new IndexOutOfBoundsException("队列为空");
        return nums[0];
    }

    private void grow() {
        if (nums.length == Integer.MAX_VALUE) return;
        int len = nums.length << 1;
        if (len < 0) len = Integer.MAX_VALUE;
        System.out.println(String.format("完成扩容：%d -> %d", nums.length, len));
        nums = Arrays.copyOf(nums, len);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        int[] arr = new int[]{35, 88, 45, 37, 91, 26, 13, 66, 50, 16, 7, 3, 20, 17, 8, 67, 21};
        for (int i : arr) {
            queue.offer(i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(queue.peek());
    }
}
