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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode main = new ListNode(-1);
        ListNode holder = main; 
        for(ListNode list : lists){
            main.next = list;
            while(main.next != null){
                main = main.next;
            }
        }
        main = sortList(holder.next);
        return main;
    }
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        //half the list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1,l2); 
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode ans = new ListNode(-1);
        ListNode ansH = ans;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ans.next = l1;
                l1 = l1.next;
            }else{
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if(l1 != null){
            ans.next = l1;
        }
        if(l2 != null){
            ans.next = l2;
        }
        return ansH.next;
    }
}