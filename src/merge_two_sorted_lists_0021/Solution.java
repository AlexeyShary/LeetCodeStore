// https://leetcode.com/problems/merge-two-sorted-lists/

package merge_two_sorted_lists_0021;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head;

        if (list1.val <= list2.val) {
            head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            head = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode currentNode = head;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                ListNode newNode = new ListNode(list2.val);
                currentNode.next = newNode;
                currentNode = newNode;
                list2 = list2.next;
                continue;
            }

            if (list2 == null) {
                ListNode newNode = new ListNode(list1.val);
                currentNode.next = newNode;
                currentNode = newNode;
                list1 = list1.next;
                continue;
            }

            if (list1.val <= list2.val) {
                ListNode newNode = new ListNode(list1.val);
                currentNode.next = newNode;
                currentNode = newNode;
                list1 = list1.next;
            } else {
                ListNode newNode = new ListNode(list2.val);
                currentNode.next = newNode;
                currentNode = newNode;
                list2 = list2.next;
            }
        }

        return head;
    }
}
