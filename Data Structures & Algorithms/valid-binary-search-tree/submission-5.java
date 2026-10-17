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
    public boolean isValidBST(TreeNode root) {
        //boundary condition for min max
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, int min, int max){
        //base condition
        if(root==null){
            return true;
        }
        //condition where BST is not valid
        if(root.val>=max || root.val<=min){
            return false;
        }
        // both left, right should be valid
        //for left, right condition(max) should update
        //for right, left condition(min) should update
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
}
