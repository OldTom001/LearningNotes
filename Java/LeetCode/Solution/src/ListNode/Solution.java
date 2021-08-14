package ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        int sum = 0;
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            sum = (n1 + n2 + add) % 10;
            add = (n1 + n2 + add) / 10;
            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (add > 0) {
            tail.next = new ListNode(add);
        }
        return head;
    }
}
