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
    public ListNode sortList(ListNode head) {
        head = mergeSort(head);
        return head;    
    }
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode sortedLeft = mergeSort(head);
        ListNode sortedRight = mergeSort(slow);

        return mergeTwoLists(sortedLeft,sortedRight);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode ansHolder = ans;
        while(list1 != null && list2 != null){
            if(list1.val<=list2.val){
                ans.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                ans.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            ans = ans.next;
        }
        if(list1 != null){
            ans.next = list1;   
        }
        if(list2 != null){
            ans.next = list2;
        }
        return ansHolder.next;
    }
}