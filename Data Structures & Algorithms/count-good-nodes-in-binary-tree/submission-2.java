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
    public int goodNodes(TreeNode root) {
        //we need private method to pass root and it's value as max
       return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max){
        //base condition
        if(root==null){
            return 0;
        }
        //so for time being, considering the root value as max value
        int count=0;//for output
        //first time, root will come, this will be always true, as equal
        if(root.val>=max){
            count++;
        }
        //update the max value
        max=Math.max(max, root.val);
        //left and right traversal
        count=count+dfs(root.left, max);
        count=count+dfs(root.right, max);
        return count;
    }
}
