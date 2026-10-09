/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // we are at mid
        ListNode l2 = slow;
        prev.next = null;
        ListNode l1 = head;

        l2 = reverseList(l2);

        ListNode n1 = l1.next;
        ListNode n2 = l2.next;

        while(n1 != null){
            l1.next = l2;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
            n1 = n1.next;
            n2 = n2.next;
        }

        l1.next = l2;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}