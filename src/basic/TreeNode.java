package basic;

import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int v0, Integer... values) {
        this.val = v0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int index = 0;
        queue.addLast(this);
        while (index < values.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (index < values.length && values[index] != null) {
                    node.left = new TreeNode(values[index]);
                    queue.addLast(node.left);
                }
                index++;
                if (index < values.length && values[index] != null) {
                    node.right = new TreeNode(values[index]);
                    queue.addLast(node.right);
                }
                index++;
            }
        }
    }

    @Override
    public String toString() {
        LinkedList<Integer> arr = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(this);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    arr.addLast(node.val);
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                } else {
                    arr.addLast(null);
                }
            }
        }
        while (arr.peekLast() == null) {
            arr.removeLast();
        }
        return arr.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, 2, 3, 4, 5);
        System.out.println(root);
    }
}