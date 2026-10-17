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
    public int maxDepth(TreeNode root) {
        //base condition
        if(root==null){
            return 0;
        }
        //left and right depth
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        //take the maximum value and increment by 1 and that is the answer
        int depth=Math.max(left,right);
        return 1+ depth;
    }
}
