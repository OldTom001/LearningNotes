package ListNode;

import java.util.HashSet;
import java.util.Set;

public class Cycle01 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            Set<ListNode> nodes = new HashSet<>();
            ListNode cur = new ListNode();
            cur = head;
            while (cur != null) {
                if (nodes.contains(cur)) {
                    return cur;
                } else {
                    nodes.add(cur);
                }
                cur = cur.next;
            }
            return null;
        }
    }
}