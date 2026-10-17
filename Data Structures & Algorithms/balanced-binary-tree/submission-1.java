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
    //global variable
    boolean balance=true;
    public boolean isBalanced(TreeNode root) {
        checkBalance(root);
        return balance;
    }

    private int checkBalance(TreeNode root){
        //base condition
        if(root==null){
            return 0;
        }
         //post order traversal
        int left=checkBalance(root.left);
        int right=checkBalance(root.right);
        //condition-hook
        if(Math.abs(left-right)>1){
            balance = false;
        }
        //same return statement for above node
        return 1+Math.max(left, right);

    }
}
