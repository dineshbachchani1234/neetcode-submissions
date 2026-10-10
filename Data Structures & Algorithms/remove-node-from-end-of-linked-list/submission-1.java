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
        ListNode dummy = new ListNode(0);
        //dummy node so we reach slow pointer one position before the node 
        //which we wish to delete/remove
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        //move the fast pointer till n times(to maintain the gap between slow/fast)
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        //reach fast to null, means slow reach the step back which we need to delete
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        //remove the node by changing the next position
        slow.next=slow.next.next;
        //return the head which is dummy next
        return dummy.next;
    }
}
