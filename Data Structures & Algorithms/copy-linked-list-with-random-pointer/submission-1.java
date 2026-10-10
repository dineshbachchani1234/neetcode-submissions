/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //map to store real values and copy values
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            //store both real and copy values
            //real value as key, and copy as value
            map.put(temp, new Node(temp.val));
            temp=temp.next;
        }

        temp=head;
        while(temp!=null){
            //get copy value using key which is real value
            Node copy = map.get(temp);
            //get the next location pointer
            copy.next=map.get(temp.next);
            //get random pointer
            copy.random=map.get(temp.random);
            temp=temp.next;
        }
        //return the copy head so entire list 
        return map.get(head);
    }
}
