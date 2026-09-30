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
        prev.next = null;

        ListNode l2 = reverseList(slow);
        ListNode l1 = head;
        
        // draw and see how it works
        while(l1.next != null){
            // store next p of l1 and l2
            ListNode l1N = l1.next;
            ListNode l2N = l2.next;

            l2.next = l1.next;
            l1.next = l2;
            l1 = l1N;
            l2 = l2N;
        }
        // for last elemnet;
        l1.next = l2;
        
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            // curr.next == prev
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}