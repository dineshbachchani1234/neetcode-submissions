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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //base condition
        if(root==null){
            return false;
        }
        //start checking with root of main tree, and subRoot, and check if equal or not
        if(sameTree(root, subRoot)){
            return true;
        }
        //if not equal, check either left or right, atleast one of root is equal 
        //to subRoot or not
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //same method of sameTree
    private boolean sameTree(TreeNode a, TreeNode b){
        //both null, pattern matches, return true
        if(a==null && b==null){
            return true;
        }
        //one null, one not, pattern not matches, return false
        if(a==null||b==null){
            return false;
        }
        //value mismatch, return false
        if(a.val!=b.val){
            return false;
        }
        //call the same method for left and right
        return sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }
}
