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
    int count=0;
    int result=0;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root){
        //base condition
        if(root==null){
            return;
        }
        //In Order Traversal
        //left
        dfs(root.left);
        //exit condition - In
        if(count==1){
            result=root.val;
        }
        count--;
        if(count>0){
        //right
        dfs(root.right);
        }
    }
}
