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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        if(n == size)return head.next;
        int hops = (size - n)-1; // to land at prev node than target

        ListNode temp2 = head;
        while(hops>0){
            temp2 = temp2.next;
            hops--;
        }
        temp2.next = temp2.next.next;

        return head;
    }
}