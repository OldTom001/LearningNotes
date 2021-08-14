package ListNode;

public class Cycle02 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next;
                fast = fast.next;
                slow = slow.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode find = fast;
                while (find != head) {
                    find = find.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}