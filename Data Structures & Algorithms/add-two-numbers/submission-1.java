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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //dummy pointer just to have extra starting, so we can return dummy.next for o/p
        ListNode dummy = new ListNode(0);
        ListNode temp=dummy;
        //carry to store
        int carry=0;
        //check if any of the list have some values
        while(l1!=null || l2!=null){
            //if node is present, take value otherwise 0
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            int sum=x+y+carry;
            //carry for integer division, as carry is first value, e.g. for 15, carry is 1
            carry=sum/10;
            //node will take value of second, e.g. for 15, take 5
            temp.next=new ListNode(sum%10);
            //increment temp to travel
            temp=temp.next;
            //if any one of the list have values, increment
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        //if both list are empty, but carry have some value, create one node for that
        if(carry>0){
            temp.next=new ListNode(carry);
        }
        //return dummy next value which is start of the final addition list
        return dummy.next;
    }
}
