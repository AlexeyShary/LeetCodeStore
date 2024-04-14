package add_two_numbers_0002;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        boolean overflow = false;

        while (l1 != null || l2 != null || overflow) {
            int val = 0;

            if (overflow) {
                val++;
                overflow = false;
            }

            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            if (val > 9) {
                val %= 10;
                overflow = true;
            }

            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }

        return head;
    }
}