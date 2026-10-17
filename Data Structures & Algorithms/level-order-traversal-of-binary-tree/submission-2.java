/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        //base condition, return empty list
        if(root==null){
            return output;
        }
        //queue of treenode
        Queue<TreeNode> queue = new LinkedList<>();
        //insert root inside queue
        queue.offer(root);
        //loop till queue is not empty
        while(!queue.isEmpty()){
            //inner loop till the size of queue
            int length=queue.size();
            //subList
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<length;i++){
                //pop the element and add in the sublist
                TreeNode a=queue.poll();
                subList.add(a.val);
                //check the left, right element of popped element and
                // insert in queue if present
                if(a.left!=null){
                    queue.offer(a.left);
                }
                if(a.right!=null){
                    queue.offer(a.right);
                }
            }
            //apped subList to output list
            output.add(subList);
        }
        return output;
    }
}
