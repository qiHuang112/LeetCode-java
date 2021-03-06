package basic;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int v0, int... values) {
        this.val = v0;
        ListNode temp = this;
        for (int value : values) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }
    }

    public ListNode append(ListNode node) {
        ListNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d -> %s", this.val, this.next);
    }
}
