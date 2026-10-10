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
        if(head==null || head.next==null){
            return;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //second list start from slow.next(either even or odd)
        ListNode secondHalf=reverseList(slow.next);
        //we got the second half, so we end our first half after slow
        slow.next=null;
        //now we will merge both list, first and second reverse list
        mergeList(head, secondHalf);  
    }

    private ListNode reverseList(ListNode slow){
        ListNode prev=null;
        ListNode curr=slow;
        while(curr!=null){
            ListNode currNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currNext;
        }
        return prev;
    }

    private void mergeList(ListNode list1, ListNode list2){
        while(list1!=null && list2!=null){
            ListNode list1Next=list1.next;
            ListNode list2Next=list2.next;
            list1.next=list2;
            
            list2.next=list1Next;
            list1=list1Next;
            list2=list2Next;
        }
    }
}
