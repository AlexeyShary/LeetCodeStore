// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list
package double_a_number_represented_as_a_linked_list;

public class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode resultHead = head;

        if (head.val > 4) {
            resultHead = new ListNode(1);
            resultHead.next = head;
        }

        doubleNodes(head);

        return resultHead;
    }

    public void doubleNodes(ListNode node) {
        node.val = (node.val*2) % 10;

        if (node.next != null) {
            if (node.next.val > 4) {
                node.val++;
            }

            doubleNodes(node.next);
        }
    }
}